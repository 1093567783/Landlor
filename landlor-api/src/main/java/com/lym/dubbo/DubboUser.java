package com.lym.dubbo;

import dto.UserDTO;
import vo.UserVO;

/**
 * 用户接口
 */
public interface DubboUser {

    void saveUser();

    UserVO login(UserDTO userDTO);
}
