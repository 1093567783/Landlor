package com.lym.model.contract.dto;

import com.lym.model.common.BaseEntityDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 房东实体
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Data
public class LandlordDTO extends BaseEntityDTO implements Serializable{
    /**
     * 房东id
     */
    private Integer id;

    /**
     * 身份证号码
     */
    private String cardId;

    /**
     * 名字
     */
    private String name;

    /**
     * 性别
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
     * 职务
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

    private static final long serialVersionUID = 1L;
}
