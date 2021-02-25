package com.lym.controller.leave;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboActivity;
import com.lym.dubbo.DubboLeave;
import com.lym.model.common.Constant;
import com.lym.model.common.Result;
import com.lym.model.leave.LeaveDTO;
import com.lym.model.leave.LeaveVO;
import com.lym.model.user.vo.UserVO;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author LYM
 * @Description 假单控制层
 * @Date 2021/2/20
 * @Version v1.0.0
 **/
@RestController
public class LeaveController {
    @Reference
    private DubboLeave dubboLeave;
    @Reference
    private DubboActivity dubboActivity;
    
    @RequestMapping("saveStartLeave")
    public Result saveStartLeave(LeaveDTO leavebill){
        Result result = new Result();
        leavebill.setState(1);
        leavebill.setLeavedate(new Date());
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        leavebill.setUserId(userVO.getId().longValue());
        dubboLeave.saveStartLeave(leavebill);
        dubboActivity.saveStartProcess(Constant.Leave_KEY,leavebill.getId().intValue(),userVO.getRealName());
        return result;
    }
    @RequestMapping("/myLeaveBill")
    public Result myBaoxiaoBill(){
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        List<LeaveVO> list = dubboLeave.findLeaveListByUserId(userVO.getId());
        result.setData(list);
        return result;
    }

    @RequestMapping("/viewHisCommentLeave")
    public Result viewHisComment(long id){
        Result result = new Result();
        LeaveVO leavebill = dubboLeave.findLeaveBillById(id);
        List<Comment> comment = dubboActivity.findCommentByBaoxiaoBillId(Constant.Leave_KEY,id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("commentList",comment);
        mav.addObject("bill",leavebill);
        mav.setViewName("leaveWorkflow_commentlist");

        return result;

    }
    @RequestMapping("/deleteLeaveBill")
    public Result deleteLeaveBill(long billId){
        Result result = new Result();
        dubboLeave.deleteLeaveBillById(billId);
        return result;
    }
    @RequestMapping("/viewCurrentImageByBillLeave")
    public Result viewCurrentImageByBillLeave(long billId) {
        Result result = new Result();
        ModelAndView mav=new ModelAndView();
        String businessKey= Constant.Leave_KEY+"."+billId;
        Task task = dubboActivity.findTaskByBussinessKey(businessKey);
        Map<String, Object> map = dubboActivity.findCoordingByTask(task.getId());
        ProcessDefinition definition = dubboActivity.findProcessDefinitionByTaskId(task.getId());
        mav.addObject("deploymentId",definition.getDeploymentId());
        mav.addObject("imageName",definition.getDiagramResourceName());
        mav.addObject("acs",map);
        mav.setViewName("viewimage");
        return result;
    }
    @RequestMapping("/myLeaveList")
    public Result myTaskList(Model model){
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        List<Task> list = dubboActivity.findLeaveTaskListByName(userVO.getRealName());
        result.setData(list);
        return result;
    }
}
