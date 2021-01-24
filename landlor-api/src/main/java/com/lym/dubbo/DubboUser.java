package com.lym.dubbo;

import com.lym.model.user.dto.UserDTO;
import com.lym.model.user.vo.UserVO;

import java.util.List;

/**
 * 用户接口
 */
public interface DubboUser {

    /**
     * 保存用户信息
     */
    void saveUser(UserDTO userDTO);

    /**
     * 根据用户名获取用户实体
     * @param name
     * @return
     */
    UserVO getUserByName(String name);

    /**
     * 获取所有用户
     * @param userDTO
     * @return
     */
    List<UserVO> findAllUser(UserDTO userDTO);

    /**
     * 获取用户
     * @param userDTO
     * @return
     */
    UserVO getUserById(UserDTO userDTO);
}
