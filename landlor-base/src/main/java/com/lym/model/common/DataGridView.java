package com.lym.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author LYM
 * @Description layui的返回列表
 * @Date 2021/1/27
 * @Version v1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView implements Serializable {

    private Integer code = 0;
    private String msg = "";
    private Long count;
    private Object data;

    public DataGridView(Object data) {
        this.data = data;
    }

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }


}
