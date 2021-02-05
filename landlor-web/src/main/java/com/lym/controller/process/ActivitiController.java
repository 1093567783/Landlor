package com.lym.controller.process;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboActivity;
import com.lym.model.common.Result;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/process/")
public class ActivitiController {
    @Reference
    private DubboActivity dubboActivity;

    @PostMapping("deployProcess")
    public Result deployProcess(@RequestParam("file") MultipartFile file) {
        System.out.println(123);
        Result result = new Result();
        try {
            dubboActivity.addNewProcess(file.getInputStream(),"测试");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("processDefinitionList")
    public String processDefinitionList(Model model){
        List<Deployment> deploymentList = dubboActivity.findDeploymentList();
        List<ProcessDefinition> definitionList = dubboActivity.findProcessDefinitionList();
        model.addAttribute("depList",deploymentList);
        model.addAttribute("pdList",definitionList);
        return "workflow_list";
    }



    @RequestMapping("/deleteDeployment")
    public String deleteDeployment(String deploymentId){
        //使用部署对象ID，删除流程定义
        dubboActivity.deleteProcessDefinitionByDeploymentId(deploymentId);
        return "redirect:/processDefinitionList";
    }

}
