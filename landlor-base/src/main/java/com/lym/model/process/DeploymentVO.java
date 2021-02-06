package com.lym.model.process;

import lombok.Data;
import org.activiti.engine.repository.Deployment;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 部署流程实体
 * @Date 2021/2/5
 * @Version v1.0.0
 **/
@Data
public class DeploymentVO implements Deployment,Serializable {
    private String id;
    private String name;
    private Date deploymentTime;
    private String category;
    private String tenantId;

}
