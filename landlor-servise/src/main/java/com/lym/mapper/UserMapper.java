package com.lym.mapper;

import com.lym.model.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import com.lym.model.user.vo.UserVO;

/**
 * 用户的dao接口
 */
@Mapper
public interface UserMapper {

    UserVO login(UserDTO userDTO);
}
