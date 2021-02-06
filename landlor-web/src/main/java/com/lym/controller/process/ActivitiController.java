package com.lym.controller.process;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboActivity;
import com.lym.model.common.BaseEntityDTO;
import com.lym.model.common.Result;
import com.lym.model.process.DeployeeDTO;
import com.lym.model.process.DeploymentVO;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/process/")
public class ActivitiController {

    @Reference
    private DubboActivity dubboActivity;

    @PostMapping("deployProcess")
    public Result deployProcess(@RequestParam("file") MultipartFile file, String processName) throws Exception{
        Result result = new Result();
        try {
            InputStream input = file.getInputStream();
            DeployeeDTO deployeeDTO = new DeployeeDTO();
            byte[] byt = new byte[input.available()];
            deployeeDTO.setInputStream(byt);
            deployeeDTO.setProcessName(processName);
            dubboActivity.addNewProcess(deployeeDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取流程定义列表
     * @return
     */
    @RequestMapping("processDefinitionList")
    public Result processDefinitionList(BaseEntityDTO baseEntityDTO){
        Result result = new Result();
        List<ProcessDefinition> definitionList = dubboActivity.findProcessDefinitionList();
        result.setData(definitionList);
        return result;
    }

    /**
     * 获取流程部署列表
     * @return
     */
    @RequestMapping("deploymentList")
    public Result deploymentList(BaseEntityDTO baseEntityDTO){
        Result result = new Result();
        List<Deployment> deploymentList = dubboActivity.findDeploymentList();
        List<DeploymentVO> deploymentVOS = new ArrayList<>();
        for (Deployment deployment:deploymentList){
            DeploymentVO deploymentVO = new DeploymentVO();
            deploymentVO.setId(deployment.getId());
            deploymentVO.setCategory(deployment.getCategory());
            deploymentVO.setDeploymentTime(deployment.getDeploymentTime());
            deploymentVO.setName(deployment.getName());
            deploymentVO.setTenantId(deployment.getTenantId());
            deploymentVOS.add(deploymentVO);
        }

        result.setData(deploymentVOS);
        System.out.println(deploymentVOS.toString());
        result.setCode(0);
        return result;
    }

    /**
     * 删除已部署的流程
     * @param deploymentId
     * @return
     */
    @RequestMapping("/deleteDeployment")
    public String deleteDeployment(String deploymentId){
        //使用部署对象ID，删除流程定义
        dubboActivity.deleteProcessDefinitionByDeploymentId(deploymentId);
        return "redirect:/processDefinitionList";
    }

}
