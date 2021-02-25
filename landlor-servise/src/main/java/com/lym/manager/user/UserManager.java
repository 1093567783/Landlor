package com.lym.manager.user;


import com.lym.mapper.user.UserMapper;
import com.lym.model.user.dto.UserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lym.model.user.vo.UserVO;

import java.util.Date;
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

    /**
     * 保存用户
     * @param userDTO
     */
    public void saveUser(UserDTO userDTO){
        userDTO.setJoinTime(new Date());
        userDTO.setUpdateTime(new Date());
        userMapper.saveUser(userDTO);
    };

    public UserVO getUser() {
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        return userVO;
    }
    /**
     * 通过登录名获取用户
     * @param name
     * @return
     */
    public UserVO getUserByName(String name) {
       return userMapper.getUserByName(name);
    }

    /**
     * 获取所有用户
     * @param userDTO
     * @return
     */
    public List<UserVO> findAllUser(UserDTO userDTO) {
        return userMapper.findAllUser(userDTO);
    }

    /**
     * 修改用户
     * @param userDTO
     */
    public void updateUser(UserDTO userDTO) {
        userMapper.updateUser(userDTO);
    }

    /**
     * 删除用户
     * @param userDTO
     */
    public void deleteUser(UserDTO userDTO) {
        userMapper.deleteByPrimaryKey(userDTO.getId().intValue());
    }

    /**
     * 根据id选择用户
     * @param id
     * @return
     */
    public UserVO getUserById(Byte id) {
       return userMapper.selectByPrimaryKey(id.intValue());
    }
}
