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

    @RequestMapping("saveUser")
    public void SaveUser(){
        System.out.println(1111);
    }

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
        Serializable authToken = subject.getSession().getId();
        Map<String, Object> remap = new HashMap<>();
        result.setData(remap);
        Cookie cookie = new Cookie("JSESSIONID",authToken.toString());
        cookie.setPath("/");
        response.addCookie(cookie);
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
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

    @RequestMapping("findAllUser")
    public Result<Object> findAllUser (UserDTO userDTO){
        // log.info(userName.toString());
        Result<Object> result = new Result<>();
        // UserDTO userDTO = new UserDTO();
        //userDTO.setUserName(userName);
        List<UserVO> userVOS = dubboUser.findAllUser(userDTO);
        result.setData(userVOS);
        log.info(userVOS.toString());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

}
