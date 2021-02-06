package com.lym.model.process;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @Author LYM
 * @Description 部署流程实体
 * @Date 2021/2/5
 * @Version v1.0.0
 **/
@Data
@AllArgsConstructor
public class DeployeeDTO implements Serializable {
    //zip流
    private byte[] inputStream;
    /**流程名*/
    private String processName;

    public DeployeeDTO() {
    }
}
