package com.lym.manager.user;

import com.github.pagehelper.PageHelper;
import com.lym.mapper.user.RoleMapper;
import com.lym.model.common.Constant;
import com.lym.model.common.DataGridView;
import com.lym.model.user.dto.RoleDTO;
import com.lym.model.user.vo.RoleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LYM
 * @Description 角色业务逻辑
 * @Date 2021/1/26
 * @Version v1.0.0
 **/
@Component
public class RoleManager {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取所有角色
     * @param roleDTO
     * @return
     */
    public DataGridView loadAllAvailableRoleNoPage(RoleDTO roleDTO) {
        List<RoleVO> roles = roleMapper.findAvailable(roleDTO);
        List<Integer> roleIds = roleMapper.queryRoleIdsByUserId(roleDTO.getUserId());
        // 因为前端表格需要 lay_checked  所以我们进行组装
        List<Map<String, Object>> lists = new ArrayList<>();
        // 查询到所以有角色
        for (RoleVO role : roles) {
            // 定义是否选中
            Boolean LAY_CHECKED = false;
            // 循环该用户的角色
            for (Integer roleId : roleIds) {
                // 判断 有这个角色 进行选中
                if (role.getId().equals(roleId)) {
                    LAY_CHECKED = true;
                    break;
                }
            }
            // 组装数据
            Map<String, Object> map = new HashMap<>();
            map.put("id", role.getId());
            map.put("name", role.getName());
            map.put("remark", role.getRemark());
            map.put("LAY_CHECKED", LAY_CHECKED);
            lists.add(map);
        }
        // 返回
        return new DataGridView(Long.valueOf(lists.size()), lists);
    }

    /**
     * 查询角色数据
     *
     * @param roleDTO
     * @return
     */
    public List<RoleVO> queryAllRole(RoleDTO roleDTO) {
       int page = roleDTO.getPage()-1;
        PageHelper.startPage(page,roleDTO.getLimit());
        return this.roleMapper.selectPage(roleDTO);
    }

    /**
     * 保存角色数据
     *
     * @param role
     */

    public RoleVO saveRole(RoleDTO role) {
        this.roleMapper.insertSelective(role);
        return null;
    }

    /**
     * 更新角色信息
     *
     * @param role
     */

    public RoleVO updateRole(RoleDTO role) {
        this.roleMapper.updateByPrimaryKeySelective(role);
        return null;
    }

    /**
     * 根据角色ID查询当前角色已拥有的菜单和权限 集合
     *
     * @param id
     * @return 菜单和权限id
     */

    public List<Integer> queryMenuIdsByRid(Integer id) {
        return this.roleMapper.queryMenuIdsByRid(id);
    }

    /**
     * 保存角色和菜单权限 关系
     *
     * @param rid
     * @param mids
     */

    public void saveRoleMenu(Integer rid, Integer[] mids) {
        // 根据角色ID删除sys_role_menu 里面的数据
        this.roleMapper.deleteRoleMenuByRid(rid);
        // 判断是否为空啥的
        if (null != mids && mids.length > 0) {
            // 进行批量 优化删除
            this.roleMapper.insertRoleMenu(rid, mids);
        }
    }


    /**
     * 根据用户ID  查询拥有的角色名称
     *
     * @param id
     * @return
     */

    public List<String> queryRoleNamesByUid(Integer id) {
        // 根据用户ID 查询角色名称
        List<Integer> roles = this.roleMapper.queryRoleIdsByUserId(id);
        // 根据角色id  查询对应的角色 名称
        if (null != roles && roles.size() > 0) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(id);
            roleDTO.setAvailable(Constant.AVAILABLE_TRUE);
            List<RoleVO> roles1 = this.roleMapper.selectPage(roleDTO);
            ArrayList<String> rolesName = new ArrayList<>();
            for (RoleVO role : roles1) {
                rolesName.add(role.getName());
            }
            return rolesName;
        }
        return null;
    }



    /**
     * 重写mq删除方法
     *
     * @param id
     * @return
     */

    public boolean removeById(Integer id) {
        // 根据角色ID删除角色和菜单之间的关系
        this.roleMapper.deleteRoleMenuByRid(id);
        // 根据角色ID删除角色和用户之间的关系
        this.roleMapper.deleteRoleUserByRid(id);
        // 删除角色表数据
        return roleMapper.deleteByPrimaryKey(id) >0?true:false;
    }
}
