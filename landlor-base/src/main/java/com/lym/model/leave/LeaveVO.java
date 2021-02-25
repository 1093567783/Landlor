package com.lym.model.leave;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 假单实体
 * @Date 2021/2/20
 * @Version v1.0.0
 **/
@Data
public class LeaveVO implements Serializable{
    private Long id;

    private Integer days;

    private String content;

    private String remark;

    private Date leavedate;

    private Integer state;

    private Long userId;

    private static final long serialVersionUID = 1L;
}
