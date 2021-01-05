package com.lym.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboUser;
import dto.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.UserVO;

/**
 * @Author LYM
 * @Description 用户控制类
 * @Date 2020/12/28
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/user/")
public class UserController {

    @Reference
    private DubboUser dubboUser;

    @RequestMapping("saveUser")
    public void SaveUser(){
        System.out.println(1111);
    }

    @RequestMapping("login")
    public UserVO login(@RequestBody UserDTO userDTO){
        return dubboUser.login(userDTO);
    }
}
