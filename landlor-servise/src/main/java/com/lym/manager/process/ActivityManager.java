package com.lym.manager.process;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.manager.contract.ContractManager;
import com.lym.model.common.TypeUtil;
import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.vo.ContractVO;
import com.lym.model.process.DeployeeDTO;
import com.lym.model.user.vo.UserVO;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.api.LongArrayAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @Author LYM
 * @Description 流程实现类
 * @Date 2021/2/4
 * @Version v1.0.0
 **/
@Component
public class ActivityManager{

    @Resource
    private RepositoryService repositoryService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;
    @Resource
    private HistoryService historyService;

    UserVO userVO = null;
    @Autowired
    private ContractManager contractManager;

    public UserVO getUser(){
        return userVO;
    }
    /**
     * 查询流程
     * @return
     */
    public List<Deployment> findDeploymentList(){
        List<Deployment> list = repositoryService.createDeploymentQuery()
                .orderByDeploymentId()
                .asc()
                .list();
        return list;
    }

    /**
     * 部署流程
     */
    public void addNewProcess(DeployeeDTO deployeeDTO){
        InputStream input = new ByteArrayInputStream(deployeeDTO.getInputStream());
        System.out.println(input);
        ZipInputStream zipInputStream=new ZipInputStream(input);
        Deployment deployment = repositoryService.createDeployment()
                .name(deployeeDTO.getProcessName())
                .addZipInputStream(zipInputStream)
                .deploy();
    }

    public List<ProcessDefinition> findProcessDefinitionList(){
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .orderByDeploymentId()
                .asc()
                .list();
        return list;
    }

    /**
     * 开始实例流程
     * @param key
     * @param id
     * @param username
     */
    public void saveStartProcess(String key,Integer id, String username) {
        String taskKey=key+"."+id;
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("inputUser",username);
        map.put("objId",taskKey);
        runtimeService.startProcessInstanceByKey(key,taskKey,map);
    }

    /**
     * 通过流程名称获取流程列表
     * @param username
     * @return
     */
    public List<Task> findTaskListByName(String username,String processName) {
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(username)
                .orderByTaskId()
                .asc()
                .list();
        List<Task> baoxiaoList=new ArrayList<Task>();
        if (list!=null&&list.size()>0){
            for (Task task : list) {
                String id = task.getProcessDefinitionId();
                if (id.indexOf(processName)!=-1){
                    baoxiaoList.add(task);
                }
            }
            return baoxiaoList;
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     */
    public List<Task> findLeaveTaskListByName(String username) {
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(username)
                .orderByTaskId()
                .asc()
                .list();
        List<Task> leaveBillList=new ArrayList<Task>();
        if (list!=null&&list.size()>0){
            for (Task task : list) {
                String id = task.getProcessDefinitionId();
                if (id.indexOf("leaveBill")!=-1){
                    leaveBillList.add(task);
                }
            }
            return leaveBillList;
        }
        return null;
    }


    public List<Comment> findCommentByTaskId(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        List<Comment> list = taskService.getProcessInstanceComments(task.getProcessInstanceId());
        if (list!=null&&list.size()>0){
            return list;
        }
        return null;
    }


    public List<String> findOutComeListByTaskId(String taskId) {
        List<String> list=new ArrayList<String>();
        Task task=taskService.createTaskQuery().taskId(taskId).singleResult();
        String definitionId = task.getProcessDefinitionId();
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(definitionId);
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        String activityId = processInstance.getActivityId();
        ActivityImpl activity = processDefinition.findActivity(activityId);
        List<PvmTransition> outgoingTransitions = activity.getOutgoingTransitions();
        if (outgoingTransitions!=null&&outgoingTransitions.size()>0){
            for (PvmTransition outgoingTransition : outgoingTransitions) {
                String name = (String) outgoingTransition.getProperty("name");
                if (StringUtils.isNotBlank(name)){
                    list.add(name);
                }else {
                    list.add("默认提交");
                }
            }
        }
        return list;
    }

//    @Override
//    public void saveSubmitTask(long id, String taskId, String comment, String outcome, String username) {
//        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
//        String pdid= task.getProcessDefinitionId();
//        Authentication.setAuthenticatedUserId(username);
//
//        taskService.addComment(taskId,task.getProcessInstanceId(),comment);
//        Map<String,Object> map=new HashMap<String, Object>();
//        if (outcome!=null&&!"默认提交".equals(outcome)){
//            map.put("message",outcome);
//            taskService.complete(taskId,map);
//        }else {
//            taskService.complete(taskId);
//        }
//
//        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
//        if (processInstance==null&&pdid.indexOf("baoxiao")!=-1){
//            Baoxiaobill baoxiaobill = baoxiaobillMapper.selectByPrimaryKey((int) id);
//            baoxiaobill.setState(2);
//            baoxiaobillMapper.updateByPrimaryKey(baoxiaobill);
//        }else {
//            Leavebill leavebill = leavebillMapper.selectByPrimaryKey(id);
//            leavebill.setState(2);
//            leavebillMapper.updateByPrimaryKey(leavebill);
//        }
//
//    }


    public List<Comment> findCommentByBaoxiaoBillId(String key,long id) {
        String businessKey=key+"."+id;
        HistoricProcessInstance instance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceBusinessKey(businessKey)
                .singleResult();
        List<Comment> comments = taskService.getProcessInstanceComments(instance.getId());
        return comments;
    }

    public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        ProcessDefinition processDefinition = repositoryService.getProcessDefinition(task.getProcessDefinitionId());
        return processDefinition;
    }

    /**
     * 流程位置图
     * @param taskId
     * @return
     */
    public Map<String, Object> findCoordingByTask(String taskId) {
        Map<String, Object> map = new HashMap<String,Object>();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService
                .getProcessDefinition(task.getProcessDefinitionId());
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId())
                .singleResult();
        ActivityImpl activity = processDefinition.findActivity(processInstance.getActivityId());
        map.put("x",activity.getX());
        map.put("y",activity.getY());
        map.put("width",activity.getWidth());
        map.put("height",activity.getHeight());
        return map;
    }

    public byte[] findImageInputStream(String deploymentId, String imageName) throws IOException {
        InputStream stream = repositoryService.getResourceAsStream(deploymentId, imageName);
        return TypeUtil.toByteArray(stream);
    }


    public Task findTaskByBussinessKey(String businessKey) {
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(businessKey).singleResult();
        return task;
    }


    public void deleteProcessDefinitionByDeploymentId(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId,true);
    }

    /**
     * 推进流程
     * @param id
     * @param taskId
     * @param comment
     * @param outcome
     * @param
     */
    public void saveSubmitTask(long id, String taskId, String comment, String outcome, UserVO userVO) {
        this.userVO = userVO;
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String pdid= task.getProcessDefinitionId();
        Authentication.setAuthenticatedUserId(userVO.getRealName());
        taskService.addComment(taskId,task.getProcessInstanceId(),comment);
        Map<String,Object> map=new HashMap<String, Object>();

        if (outcome!=null&&!"默认提交".equals(outcome)){
            map.put("message",outcome);
            taskService.complete(taskId,map);
        }else {
            taskService.complete(taskId);
        }
        //相当于回调函数
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        if (processInstance==null&&pdid.indexOf("CONTRACT")!=-1){
            ContractDTO contractDTO = new ContractDTO();
            contractDTO.setId(Long.valueOf(id).intValue());
            //ContractVO baoxiaobill = contractManager.getContractById(contractDTO);
            contractDTO.setStatus(2);
            contractManager.updateByPrimaryKeySelective(contractDTO);
        }
    }

    /**
     * 获取合同
     * @param taskId
     * @return
     */
    public ContractVO findByTaskId(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId()).singleResult();
        String businessKey = processInstance.getBusinessKey();
        String id=businessKey.substring(businessKey.indexOf(".")+1);
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setId(Integer.parseInt(id));
        ContractVO contractVO= contractManager.getContractById(contractDTO);
        if (contractVO!=null){
            contractVO.setId(Integer.parseInt(id));
            return contractVO;
        }
        return null;
    }
}
