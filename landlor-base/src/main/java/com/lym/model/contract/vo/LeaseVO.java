package com.lym.model.contract.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 租赁实体
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Data
public class LeaseVO implements Serializable{
    /**
     * 租赁id
     */
    private Integer id;

    /**
     * 房子id
     */
    private Integer houseId;

    /**
     * 租客id
     */
    private Integer customerId;

    /**
     * 合同id
     */
    private Integer contractId;

    /**
     * 地址
     */
    private String address;

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
