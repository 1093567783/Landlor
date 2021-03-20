package com.lym.model.contract.dto;

import com.lym.model.common.BaseEntityDTO;
import com.lym.model.contract.vo.CustomerVO;
import com.lym.model.contract.vo.LandlordVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 合同实体
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Data
public class ContractDTO extends BaseEntityDTO implements Serializable{
    /**
     * 合同表id
     */
    private Integer id;

    /**
     * 房东身份证号
     */
    private String landlordCard;

    /**
     * 房东id
     */
    private Integer landlordId;

    /**
     * 房源id
     */
    private Integer houseId;
    /**
     * 起租时间
     */
    private Date startTime;
    private String startTimeStr;
    /**
     * 租客身份证号
     */
    private String customerCard;

    /**
     * 租客id
     */
    private Integer customerId;

    /**
     * 退租时间
     */
    private Date endTime;
    private String endTimeStr;
    /**
     * 租金
     */
    private Double price;

    /**
     * 每月租金时间
     */
    private String payDay;

    /**
     * 创建时间
     */
    private Date joinTime;

    /**
     * 创建者
     */
    private Integer userId;

    private Date updateTime;
    private Integer status;
    private static final long serialVersionUID = 1L;
}
