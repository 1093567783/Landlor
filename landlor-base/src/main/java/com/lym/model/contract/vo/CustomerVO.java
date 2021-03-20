package com.lym.model.contract.vo;

import com.lym.model.common.BaseEntityDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 租客实体
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Data
public class CustomerVO extends BaseEntityDTO implements Serializable{
    /**
     * 租客id
     */
    private Integer id;

    /**
     * 身份证号
     */
    private String cardId;

    /**
     * 租客名字
     */
    private String name;

    /**
     * 性别0-女 1-男
     */
    private Integer sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 职业
     */
    private String work;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date joinTime;

    /**
     * 创建者id
     */
    private Integer userId;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
