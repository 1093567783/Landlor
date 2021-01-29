package com.lym.dubbo;

import com.lym.model.common.DataGridView;
import com.lym.model.user.dto.RoleDTO;

public interface DubboRole {
    /**
     * 获取角色
     * @param roleDTO
     * @return
     */
    DataGridView loadAllAvailableRoleNoPage(RoleDTO roleDTO);
}
