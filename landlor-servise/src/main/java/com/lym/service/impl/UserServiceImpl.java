package com.lym.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboUser;
import com.lym.manager.UserManager;

import com.lym.model.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.lym.service.UserService;
import com.lym.model.user.vo.UserVO;

/**
 * @Author LYM
 * @Description 用户服务实现类
 * @Date 2020/12/28
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboUser.class, delay = -1, retries = 0)
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserManager userManager;

    @Override
    public void saveUser(UserDTO userDTO) {
        userManager.saveUser(userDTO);
    }

    @Override
    public UserVO login(UserDTO userDTO) {
        System.out.println(userDTO.getPassword());
        return userManager.login(userDTO);
    }

    @Override
    public UserVO getUserByName(String name) {
        return userManager.getUserByName(name);
    }
}
