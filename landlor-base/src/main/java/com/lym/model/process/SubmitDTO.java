package com.lym.model.process;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author LYM
 * @Description 流程推进提交
 * @Date 2021/2/21
 * @Version v1.0.0
 **/
@Data
public class SubmitDTO implements Serializable{
    String id;
    String taskId;
    /**
     * 批注
     */
    String comment;
    /**
     * 按钮
     */
    String outcome;
}
