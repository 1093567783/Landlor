package com.lym.model.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 部门实体
 * @Date 2021/1/24
 * @Version v1.0.0
 **/
@Data
public class DepartmentDTO implements Serializable{
    /** 部门id*/
    private Byte id;
    /**父级部门id*/
    private Byte pid;
    /**部门名称*/
    private String title;
    /**是否展开0不展开1展开*/
    private Integer spread;
    /**备注*/
    private String remark;
    /**地址*/
    private String address;
    /**状态【0不可用1可用】*/
    private Integer available;
    /**排序码【为了调事显示顺序】*/
    private Integer ordernum;
    /**创建时间*/
    private Date createtime;
}
