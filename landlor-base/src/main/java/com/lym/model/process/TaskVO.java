package com.lym.model.process;

import lombok.Data;
import org.activiti.engine.task.DelegationState;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author LYM
 * @Description 任务实例实体
 * @Date 2021/2/21
 * @Version v1.0.0
 **/
@Data
public class TaskVO implements Serializable {
    String id;

    String name;

    String owner;

    String assignee;

    Date createTime;

    String processDefinitionId;

}
