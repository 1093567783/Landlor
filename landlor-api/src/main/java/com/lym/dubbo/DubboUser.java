package com.lym.dubbo;

import com.lym.model.user.dto.UserDTO;
import com.lym.model.user.vo.UserVO;

/**
 * 用户接口
 */
public interface DubboUser {

    /**
     * 保存用户信息
     */
    void saveUser(UserDTO userDTO);

    /**
     * 登陆功能
     * @param userDTO
     * @return
     */
    UserVO login(UserDTO userDTO);

    /**
     * 根据用户名获取用户实体
     * @param name
     * @return
     */
    UserVO getUserByName(String name);
}
