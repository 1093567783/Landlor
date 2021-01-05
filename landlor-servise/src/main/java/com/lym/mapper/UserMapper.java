package com.lym.mapper;

import dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import vo.UserVO;

/**
 * 用户的dao接口
 */
@Mapper
public interface UserMapper {

    UserVO login(UserDTO userDTO);
}
