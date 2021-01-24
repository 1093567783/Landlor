package com.lym.service.user.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboUser;
import com.lym.manager.user.UserManager;

import com.lym.model.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.lym.service.user.UserService;
import com.lym.model.user.vo.UserVO;

import java.util.List;

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
    public UserVO getUserByName(String name) {
        return userManager.getUserByName(name);
    }

    /**
     * 获取所有用户
     * @param userDTO
     * @return
     */
    @Override
    public List<UserVO> findAllUser(UserDTO userDTO) {
        return userManager.findAllUser(userDTO);
    }

    /**
     * 根据条件获取用户
     * @param userDTO
     * @return
     */
    @Override
    public UserVO getUserById(UserDTO userDTO) {
        return null;
    }
}
