package com.lym.controller.user;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboUser;
import com.lym.model.common.Result;
import com.lym.model.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lym.model.user.vo.UserVO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LYM
 * @Description 用户控制类
 * @Date 2020/12/28
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Reference
    private DubboUser dubboUser;


    @Bean(name = "dubboUser")
    public DubboUser getDubboUser(){
        return dubboUser;
    }

    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    @RequestMapping("saveUser")
    public Result saveUser(@RequestBody UserDTO userDTO){
        Result<Object> result = new Result<>();
        userDTO.setPassword("123456");
        dubboUser.saveUser(userDTO);
        return result;
    }

    /**
     * 修改用户
     * @param userDTO
     * @return
     */
    @RequestMapping("updateUser")
    public Result updateUser(@RequestBody UserDTO userDTO){
        Result<Object> result = new Result<>();
        dubboUser.updateUser(userDTO);
        return result;
    }
    /**
     * 修改用户
     * @param userDTO
     * @return
     */
    @RequestMapping("deleteUser")
    public Result deleteUser( UserDTO userDTO){
        Result<Object> result = new Result<>();
        dubboUser.deleteUser(userDTO);
        return result;
    }
    /**
     * 登录
     * @param userDTO
     * @param response
     * @return
     */
    @RequestMapping("login")
    public Result<Object> login(@RequestBody UserDTO userDTO,HttpServletResponse response) {
        Result<Object> result = new Result<>();
        if (StringUtils.isEmpty(userDTO.getUserName()) || StringUtils.isEmpty(userDTO.getPassword())) {
            return result.setError(169, "请输入用户名和密码！");
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                userDTO.getUserName(),
                userDTO.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
            String authToken = subject.getSession().getId().toString();
            Map<String, Object> map = new HashMap<>();
            map.put("token", authToken);
            result.setData(map);
            Cookie cookie = new Cookie("TOKEN",authToken);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e);
            return result.setError(169, "用户名不存在！");
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e);
            return result.setError(169, "账号或密码错误！");
        } catch (AuthorizationException e) {
            log.error("没有权限！", e);
            return result.setError(169, "没有权限");
        }
        System.out.println("登录成功" + result);
        return result;
    }

    /**
     * 获取所有用户列表
     * @param userDTO
     * @return
     */
    @RequestMapping("findAllUser")
    public Result<Object> findAllUser(UserDTO userDTO){
        Result<Object> result = new Result<>();
        List<UserVO> userVOS = dubboUser.findAllUser(userDTO);
        result.setData(userVOS);
        log.info(userVOS.toString());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    /**
     * 暂未使用
     * @param userDTO
     * @return
     */
    @RequestMapping("getUserById")
    public Result<Object> getUserById(UserDTO userDTO){
        Result<Object> result = new Result<>();
        UserVO userVO = dubboUser.getUserById(userDTO);
        result.setData(userVO);
        log.info(userVO.toString());
        result.setCode(0);
        result.setMsg("");
        return result;
    }
}
