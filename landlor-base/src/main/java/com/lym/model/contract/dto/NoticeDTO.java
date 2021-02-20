package com.lym.model.contract.dto;

import com.lym.model.common.BaseEntityDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 通知实体
 * @Date 2021/2/19
 * @Version v1.0.0
 **/
@Data
public class NoticeDTO extends BaseEntityDTO implements Serializable{
    private Integer id;

    private String title;

    private String content;

    private Date createtime;

    private String opername;

    private static final long serialVersionUID = 1L;
}
