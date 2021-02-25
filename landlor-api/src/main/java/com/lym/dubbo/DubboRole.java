package com.lym.dubbo;

import com.lym.model.common.DataGridView;
import com.lym.model.shiro.Role;
import com.lym.model.user.dto.RoleDTO;
import com.lym.model.user.vo.RoleVO;

import java.util.List;

public interface DubboRole {
    /**
     * 获取角色
     * @param roleDTO
     * @return
     */
    DataGridView loadAllAvailableRoleNoPage(RoleDTO roleDTO);

    /**
     * 查询角色数据
     * @param roleDTO
     * @return
     */
    List<RoleVO> queryAllRole(RoleDTO roleDTO);

    /**
     * 保存角色数据
     * @param role
     */
    RoleVO saveRole(RoleDTO role);

    /**
     * 更新角色信息
     * @param role
     */
    RoleVO updateRole(RoleDTO role);

    /**
     * 根据角色ID查询当前角色已拥有的菜单id集合
     * @param id
     * @return
     */
    List<Integer> queryMenuIdsByRid(Integer id);

    /**
     * 保存角色和菜单权限 关系
     * @param rid
     * @param mids
     */
    void saveRoleMenu(Integer rid, Integer[] mids);

    /**
     * 查询可用的角色
     * @param roleVo
     * @return
     */
    DataGridView queryAllAvailableRoleNoPage(RoleDTO roleVo);

    /**
     * 根据用户ID  查询拥有的角色名称
     * @param id
     * @return
     */
    List<String> queryRoleNamesByUid(Integer id);

    /**
     * 删除角色
     * @param id
     */
    void deleteRole(Integer id);

    List<Role> getRoleByUid(Byte id);
}
