package com.lym.service.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboRole;
import com.lym.dubbo.DubboUser;
import com.lym.manager.user.RoleManager;
import com.lym.model.common.DataGridView;
import com.lym.model.shiro.Role;
import com.lym.model.user.dto.RoleDTO;
import com.lym.model.user.vo.RoleVO;
import com.lym.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 角色服务实现
 * @Date 2021/1/26
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboRole.class, delay = -1, retries = 0)
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleManager roleManager;

    @Override
    public DataGridView loadAllAvailableRoleNoPage(RoleDTO roleDTO) {
        return roleManager.loadAllAvailableRoleNoPage(roleDTO);
    }

    @Override
    public List<RoleVO> queryAllRole(RoleDTO roleDTO) {
        return roleManager.queryAllRole(roleDTO);
    }

    @Override
    public RoleVO saveRole(RoleDTO role) {
        return null;
    }

    @Override
    public RoleVO updateRole(RoleDTO role) {
        return null;
    }

    @Override
    public List<Integer> queryMenuIdsByRid(Integer id) {
        return null;
    }

    @Override
    public void saveRoleMenu(Integer rid, Integer[] mids) {

    }

    @Override
    public DataGridView queryAllAvailableRoleNoPage(RoleDTO roleVo) {
        return null;
    }

    @Override
    public List<String> queryRoleNamesByUid(Integer id) {
        return null;
    }

    @Override
    public void deleteRole(Integer id) {

    }

    @Override
    public List<Role> getRoleByUid(Byte id) {
        return roleManager.getRoleByUid(id);
    }
}
