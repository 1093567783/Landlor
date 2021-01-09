package com.lym.manager;


import com.lym.mapper.UserMapper;
import com.lym.model.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lym.model.user.vo.UserVO;

/**
 * @Author LYM
 * @Description 用户逻辑实现
 * @Date 2020/12/28
 * @Version v1.0.0
 **/
@Component
public class UserManager{

    @Autowired
    private UserMapper userMapper;

    public void saveUser(){
        System.out.println("rpc成功");
    };

    public UserVO login(UserDTO userDTO) {
       return userMapper.login(userDTO);
    }
}
