package com.lym.service.process.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboActivity;
import com.lym.manager.process.ActivityManager;
import com.lym.service.process.ActivityService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author LYM
 * @Description 流程管理
 * @Date 2021/2/4
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboActivity.class, delay = -1, retries = 0)
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityManager activityManager;
    /**
     * 获取部署的流程列表
     * @return
     */
    @Override
    public List<Deployment> findDeploymentList() {
        return activityManager.findDeploymentList();
    }

    /**
     * 部署流程
     * @param in
     * @param processName
     */
    @Override
    public void addNewProcess(InputStream in, String processName) {

    }

    @Override
    public List<ProcessDefinition> findProcessDefinitionList() {
        return null;
    }

    /**
     * 开始流程实例
     * @param key
     * @param id
     * @param username
     */
    @Override
    public void saveStartProcess(String key, Integer id, String username) {

    }

    @Override
    public List<Task> findTaskListByName(String username) {
        return null;
    }

    @Override
    public List<Task> findLeaveTaskListByName(String username) {
        return null;
    }

    @Override
    public List<Comment> findCommentByTaskId(String taskId) {
        return null;
    }

    @Override
    public List<String> findOutComeListByTaskId(String taskId) {
        return null;
    }

    @Override
    public void saveSubmitTask(long id, String taskId, String comment, String outcome, String username) {

    }

    @Override
    public List<Comment> findCommentByBaoxiaoBillId(String key, long id) {
        return null;
    }

    @Override
    public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
        return null;
    }

    @Override
    public Map<String, Object> findCoordingByTask(String taskId) {
        return null;
    }

    @Override
    public InputStream findImageInputStream(String deploymentId, String imageName) {
        return null;
    }

    @Override
    public Task findTaskByBussinessKey(String businessKey) {
        return null;
    }

    @Override
    public void deleteProcessDefinitionByDeploymentId(String deploymentId) {

    }
}
