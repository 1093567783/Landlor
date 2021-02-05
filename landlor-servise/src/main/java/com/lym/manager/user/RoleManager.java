package com.lym.manager.user;

import com.lym.mapper.user.RoleMapper;
import com.lym.model.common.DataGridView;
import com.lym.model.user.dto.RoleDTO;
import com.lym.model.user.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
