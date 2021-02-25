package com.lym.model.shiro;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Author LYM
 * @Description 权限角色
 * @Date 2021/1/10
 * @Version v1.0.0
 **/
@Data
public class Role implements Serializable{
    /**
     * 角色id
     */
    private Integer id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private List<Permission> permissions;
}
