package com.lym.mapper;

import com.lym.model.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import com.lym.model.user.vo.UserVO;

/**
 * 用户的dao接口
 */
@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param userDTO
     * @return
     */
    UserVO login(UserDTO userDTO);

    /**
     * 根据用户名获取用户信息
     * @param name
     * @return
     */
    UserVO getUserByName(String name);
}
