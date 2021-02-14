package com.lym.model.contract.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 房源实体
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Data
public class HouseVO implements Serializable{
    /**
     * 房源id
     */
    private Integer id;

    /**
     * 房子编码
     */
    private String houseCode;

    /**
     * 房东id
     */
    private Integer landlordId;

    /**
     * 地址
     */
    private String address;

    /**
     * 面积
     */
    private Double area;

    /**
     * 图片
     */
    private String picture;

    /**
     * 省编码
     */
    private Integer provinceCode;

    /**
     * 城市编码
     */
    private Integer cityCode;

    /**
     * 县编码
     */
    private Integer districtCode;

    /**
     * 租金
     */
    private Double price;

    /**
     * 状态
     */
    private Integer statu;

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
