package com.lym.controller.user;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboPermission;
import com.lym.dubbo.DubboRole;
import com.lym.dubbo.DubboUser;
import com.lym.model.common.Result;
import com.lym.model.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lym.model.user.vo.UserVO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
    @Reference
    private DubboRole dubboRole;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Bean(name = "dubboUser")
    public DubboUser getDubboUser(){
        return dubboUser;
    }

    @Bean(name = "dubboRole")
    public DubboRole getDubboRole(){
        return dubboRole;
    }

    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @RequestMapping("saveUser")
    public Result saveUser(@RequestBody @Valid UserDTO userDTO,BindingResult validMsg) {
        Result<Object> result = new Result<>();
        if(validMsg.hasErrors()){
            for (ObjectError error : validMsg.getAllErrors()) {
                return result.setError(120,error.getDefaultMessage());
            }
        }
        if(!userDTO.getPassword().equals(userDTO.getRePass())){
            return result.setError(110,"两次密码不一致!!!");
        }
        UserVO userByName = dubboUser.getUserByName(userDTO.getUserName());
        if (userByName != null){
            return result.setError(130,"用户名已存在!!!");
        }
        //用户名与电话一致
        userDTO.setPhone(userDTO.getUserName());
        dubboUser.saveUser(userDTO);
        return result;
    }

    /**
     * 保存用户
     * @param userDTO
     * @return
     */
    @RequestMapping("insertUser")
    public Result insertUser(@RequestBody UserDTO userDTO) {
        Result<Object> result = new Result<>();
        userDTO.setPassword("123456");
        dubboUser.saveUser(userDTO);
        userDTO.setJoinTime(new Date());
        userDTO.setUpdateTime(new Date());
        return result;
    }
    /**
     * 修改用户
     * @param userDTO
     * @return
     */
    @RequestMapping("updateUser")
    @RequiresPermissions("updateUser")
    public Result updateUser(@RequestBody UserDTO userDTO){
        Result<Object> result = new Result<>();
        dubboUser.updateUser(userDTO);
        return result;
    }

    /**
     * 修改个人信息
     * @param userDTO
     * @return
     */
    @RequestMapping("updateMyself")
    public Result updateMyself(@RequestBody UserDTO userDTO){
        Result<Object> result = new Result<>();
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        userDTO.setId(userVO.getId());
        dubboUser.updateUser(userDTO);
        return result;
    }
    /**
     *
     * @param userDTO
     * @return
     */
    @RequestMapping("updatePassword")
    public Result updatePassword(@RequestBody UserDTO userDTO){
        Result<Object> result = new Result<>();
        if (!StringUtils.isEmpty(userDTO.getPassword())&&!StringUtils.isEmpty(userDTO.getRePass())){
            if (!userDTO.getPassword().equals(userDTO.getRePass())){
                return result.setError(120,"密码不一致");
            }
        }
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        if (!userVO.getPassword().equals(userDTO.getOldPassword())){
            return result.setError(120,"当前密码错误");
        }
        userDTO.setId(userVO.getId());
        dubboUser.updateUser(userDTO);
        return result;
    }

    @RequestMapping("detailUser")
    public Result detailUser(){
        Result<Object> result = new Result<>();
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        result.setData(userVO);
        result.setCode(0);
        return result;
    }

    /**
     * 删除用户
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
     * 返回验证码
     * 思路： 把验证码存入redis
     * 登陆时候 在进行获取出来 进行相应的判断
     * 接收的形式    key --- value
     *
     * @param response 返回出去的流
     * @param codeKey  接收验证码的key
     * @throws IOException
     */
    @RequestMapping("captcha")
    public void captcha(HttpServletResponse response, String codeKey) throws IOException {
        // 定义验证码
        ShearCaptcha captcha = CaptchaUtil.
                createShearCaptcha(100, 38, 4, 2);
        String code = captcha.getCode();

        System.out.println(code);

        // 储存到redis
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(codeKey, code);
        // 设置  缓存时间 60秒
        opsForValue.getOperations().expire(codeKey, 60, TimeUnit.SECONDS);
        // 返回流
        captcha.write(response.getOutputStream());


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
        UserVO userVO = dubboUser.getUserById(userDTO.getId());
        result.setData(userVO);
        log.info(userVO.toString());
        result.setCode(0);
        result.setMsg("");
        return result;
    }
}
