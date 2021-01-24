package com.lym.manager.user;


import com.lym.mapper.user.UserMapper;
import com.lym.model.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lym.model.user.vo.UserVO;

import java.util.List;

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

    public void saveUser(UserDTO userDTO){
        System.out.println("rpc成功");
    };



    public UserVO getUserByName(String name) {
       return userMapper.getUserByName(name);
    }

    public List<UserVO> findAllUser(UserDTO userDTO) {
        return userMapper.findAllUser(userDTO);
    }
}
