package com.lym.model.leave;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LeaveDTO implements Serializable {
    private Long id;

    private Integer days;

    private String content;

    private String remark;

    private Date leavedate;

    private Integer state;

    private Long userId;

    private static final long serialVersionUID = 1L;
}