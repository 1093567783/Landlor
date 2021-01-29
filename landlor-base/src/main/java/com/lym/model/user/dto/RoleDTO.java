package com.lym.model.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 角色实体
 * @Date 2021/1/26
 * @Version v1.0.0
 **/
@Data
public class RoleDTO implements Serializable {

    /**角色id*/
    private Integer id;
    /**角色id*/
    private Integer userId;
    /**角色名称*/
    private String name;
    /**角色备注*/
    private String remark;
    /**角色是否有效状态【0不可用1可用】*/
    private Integer available;
    /**角色创建时间*/
    private Date createtime;
}
