package com.lym.shiro;


import com.lym.dubbo.DubboPermission;
import com.lym.dubbo.DubboRole;
import com.lym.dubbo.DubboUser;
import com.lym.model.shiro.Permission;
import com.lym.model.shiro.Role;
import com.lym.model.user.vo.UserVO;
import com.lym.tool.SpringBeanFactoryUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author LYM
 * @Description 权限验证
 * @Date 2021/1/10
 * @Version v1.0.0
 **/
public class CustomRealm extends AuthorizingRealm{

    /**
     * @MethodName doGetAuthorizationInfo
     * @Description 权限配置类
     * @Param [principalCollection]
     * @Return AuthorizationInfo
     * @Author
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        DubboUser dubboUser = SpringBeanFactoryUtils.getBean("dubboUser",DubboUser.class);
        //获取登录用户名
        UserVO userVO = (UserVO) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : userVO.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (Permission permissions : role.getPermissions()) {
                System.out.println(permissions.getPermissionName());
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionName());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * @MethodName doGetAuthenticationInfo
     * @Description 认证配置类
     * @Param [authenticationToken]
     * @Return AuthenticationInfo
     * @Author WangShiLin
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        DubboUser dubboUser = SpringBeanFactoryUtils.getBean("dubboUser",DubboUser.class);
        DubboRole dubboRole = SpringBeanFactoryUtils.getBean("dubboRole",DubboRole.class);
        if (StringUtils.isEmpty(authenticationToken.getPrincipal())) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        UserVO user = dubboUser.getUserByName(name);
        List<Role> roles = dubboRole.getRoleByUid(user.getId());
        user.setRoles(roles);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }

}
