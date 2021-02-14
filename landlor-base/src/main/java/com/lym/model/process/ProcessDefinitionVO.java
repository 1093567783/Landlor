package com.lym.model.process;

import lombok.Data;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 流程定义实体
 * @Date 2021/2/6
 * @Version v1.0.0
 **/
@Data
public class ProcessDefinitionVO implements Serializable {

    private String id;
    private String name;
    private String key;
    private String category;
    private String description;
    private int version;
    private String tenantId;
    private String resourceName;
    private String diagramResourceName;
    private String deploymentId;
    private boolean startFormKey;
    private boolean suspended;

}
