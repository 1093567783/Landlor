package com.lym.mapper.user;

import com.lym.model.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import com.lym.model.user.vo.UserVO;

import java.util.List;

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
   // UserVO login(UserDTO userDTO);

    /**
     * 根据用户名获取用户信息
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
     * 根据id查询
     * @param id
     * @return
     */
    UserVO selectByPrimaryKey(Integer id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteByPrimaryKey(Integer id);

    /**
     * 条件修改用户
     * @param userDTO
     */
    void updateUser(UserDTO userDTO);

    /**
     * 条件保存用户
     * @param userDTO
     */
    void saveUser(UserDTO userDTO);

    /**
     * 全部数据保存用户
     * @param userDTO
     */
    void insert(UserDTO userDTO);
    /**
     * 全部数据修改用户
     * @param userDTO
     */
    void updateByPrimaryKey(UserDTO userDTO);

}
