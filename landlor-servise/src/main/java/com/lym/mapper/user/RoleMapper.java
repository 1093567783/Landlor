package com.lym.mapper.user;

import com.lym.model.shiro.Role;
import com.lym.model.user.dto.RoleDTO;
import com.lym.model.user.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleDTO record);

    int insertSelective(RoleDTO record);

    RoleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleDTO record);

    int updateByPrimaryKey(RoleDTO record);

    /**
     * 分页查询
     * @param record
     * @return
     */
    List<RoleVO> selectPage(RoleDTO record);
    /**
     * 中间表查找用户角色id
     * @param userId
     * @return
     */
    List<Integer> queryRoleIdsByUserId(Integer userId);

    List<Integer> queryMenuIdsByRid(@Param("id") Integer id);

    void insertRoleMenu(@Param("rid") Integer rid, @Param("mids") Integer[] mids);

    List<RoleVO> findAvailable(RoleDTO record);
    /**
     * 根据角色ID删除角色和菜单之间的关系
     *
     * @param id
     */
    void deleteRoleMenuByRid(Serializable id);

    /**
     * 根据菜单ID删除角色和菜单之间的关系
     *
     * @param id
     */
    void deleteRoleMenuByMid(Serializable id);

    /**
     * 根据角色ID删除角色和用户之间的关系
     *
     * @param id
     */
    void deleteRoleUserByRid(Serializable id);

    /**
     * 根据用户ID删除角色和用户之间的关系
     *
     * @param id
     */
    void deleteRoleUserByUid(Serializable id);

    List<Role> getRoleByUid(Byte id);
}