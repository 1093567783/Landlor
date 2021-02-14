package com.lym.controller.process;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboActivity;
import com.lym.model.common.BaseEntityDTO;
import com.lym.model.common.Result;
import com.lym.model.common.TypeUtil;
import com.lym.model.process.DeployeeDTO;
import com.lym.model.process.DeploymentVO;
import com.lym.model.process.ProcessDefinitionVO;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

@RestController
@RequestMapping("/process/")
public class ActivitiController {

    @Reference
    private DubboActivity dubboActivity;

    @PostMapping("deployProcess")
    public Result deployProcess(@RequestParam("file") MultipartFile file, String processName) throws Exception{
        Result result = new Result();
        try {
            DeployeeDTO deployeeDTO = new DeployeeDTO();
            byte[] byt = file.getBytes();
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
        List<ProcessDefinitionVO> processDefinitionDTOS = new ArrayList<>();
        System.out.println(definitionList.toString());
        for (ProcessDefinition processDefinition:definitionList){
            ProcessDefinitionVO processDefinitionVO = new ProcessDefinitionVO();
            processDefinitionVO.setId(processDefinition.getId());
            processDefinitionVO.setCategory(processDefinition.getCategory());
            processDefinitionVO.setName(processDefinition.getName());
            processDefinitionVO.setVersion(processDefinition.getVersion());
            processDefinitionVO.setKey(processDefinition.getKey());
            processDefinitionVO.setDiagramResourceName(processDefinition.getDiagramResourceName());
            processDefinitionVO.setResourceName(processDefinition.getResourceName());
            processDefinitionVO.setTenantId(processDefinition.getTenantId());
            processDefinitionVO.setDeploymentId(processDefinition.getDeploymentId());
            processDefinitionDTOS.add(processDefinitionVO);
        }
        result.setData(processDefinitionDTOS);
        result.setCode(0);
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
        result.setCode(0);
        return result;
    }

    /**
     * 删除已部署的流程
     * @param ids
     * @return
     */
    @RequestMapping("/deleteDeployment")
    public Result deleteDeployment(String ids){
        Result result = new Result();
        //使用部署对象ID，删除流程定义
        dubboActivity.deleteProcessDefinitionByDeploymentId(ids);
        return result;
    }

    /**
     * 流程图片显示
     * @param deploymentId
     * @param imageName
     * @param response
     * @throws Exception
     */
    @RequestMapping("/viewImage")
    public void viewImage(String deploymentId, String imageName, HttpServletResponse response) throws Exception {
        byte[] bytes = dubboActivity.findImageInputStream(deploymentId, imageName);
        InputStream inputStream = TypeUtil.byteInputStream(bytes);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream os = response.getOutputStream();
        int ch = 0;
        while (-1 != (ch = inputStream.read())){
            baos.write(ch);
        }
        os.write(baos.toByteArray());
        inputStream.close();
        baos.close();
        os.close();
    }
}
