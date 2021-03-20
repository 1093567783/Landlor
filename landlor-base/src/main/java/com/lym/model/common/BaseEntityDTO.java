package com.lym.model.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author LYM
 * @Description 分页基础类
 * @Date 2021/1/14
 * @Version v1.0.0
 **/
@Data
public class BaseEntityDTO implements Serializable{

    private Integer page = 1;

    private Integer limit;

    private long count;
    //操作的userId
    private Long operateUserId;


    public Long getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(Long operateUserId) {
        this.operateUserId = operateUserId;
    }
}
