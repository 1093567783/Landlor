package com.lym.model.shiro;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author LYM
 * @Description 权限类
 * @Date 2021/1/10
 * @Version v1.0.0
 **/
@Data
public class Permission implements Serializable{
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限名
     */
    private String permissionName;
}
