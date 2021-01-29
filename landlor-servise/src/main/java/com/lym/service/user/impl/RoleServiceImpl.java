package com.lym.service.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboRole;
import com.lym.dubbo.DubboUser;
import com.lym.manager.user.RoleManager;
import com.lym.model.common.DataGridView;
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
}
