package com.lym.dubbo;

import com.lym.model.user.dto.UserDTO;
import com.lym.model.user.vo.UserVO;

/**
 * 用户接口
 */
public interface DubboUser {

    void saveUser();

    UserVO login(UserDTO userDTO);
}
