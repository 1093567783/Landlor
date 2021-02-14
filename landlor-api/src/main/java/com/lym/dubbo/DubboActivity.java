package com.lym.dubbo;
import com.lym.model.process.DeployeeDTO;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author LYM
 * @Description 流程管理接口
 * @Date 2021/2/3
 * @Version v1.0.0
 **/
public interface DubboActivity {
    List<Deployment> findDeploymentList();

    void addNewProcess(DeployeeDTO deployeeDTO) throws Exception;

    List<ProcessDefinition> findProcessDefinitionList();

    void saveStartProcess(String key,Integer id, String username);

    List<Task> findTaskListByName(String username);

    List<Task> findLeaveTaskListByName(String username);


    List<Comment> findCommentByTaskId(String taskId);

    List<String> findOutComeListByTaskId(String taskId);

    void saveSubmitTask(long id, String taskId, String comment, String outcome, String username);


    List<Comment> findCommentByBaoxiaoBillId(String key,long id);

    ProcessDefinition findProcessDefinitionByTaskId(String taskId);

    Map<String, Object> findCoordingByTask(String taskId);

    byte[] findImageInputStream(String deploymentId, String imageName) throws IOException;

    Task findTaskByBussinessKey(String businessKey);

    void deleteProcessDefinitionByDeploymentId(String deploymentId);
}
