package com.lym.controller.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboContract;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.vo.ContractVO;
import com.lym.model.user.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author LYM
 * @Description 合同控制类
 * @Date 2021/2/17
 * @Version v1.0.0
 **/
@RequestMapping("/contract/")
@RestController
public class ContractController {

    @Reference
    private DubboContract dubboContract;

    /**
     * 保存合同实例
     * @param contractDTO
     * @return
     */
    @RequestMapping("saveContract")
    public Result saveContract(@RequestBody @Valid ContractDTO contractDTO,BindingResult validMsg) throws ParseException {
        Result result = new Result();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date start = sdf.parse(contractDTO.getStartTimeStr());
        Date end = sdf.parse(contractDTO.getEndTimeStr());
        contractDTO.setStartTime(start);
        contractDTO.setEndTime(end);
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        contractDTO.setJoinTime(new Date());
        contractDTO.setUserId(userVO.getId().intValue());
        contractDTO.setUpdateTime(new Date());
        dubboContract.saveContract(contractDTO);
        return result;
    }

    /**
     * 查找合同
     * @param contractDTO
     * @return
     */
    @RequestMapping("findAllContract")
    public Result findAllContract(ContractDTO contractDTO){
        Result result = new Result();
        List<ContractVO> list = dubboContract.findAllContract(contractDTO);
        result.setCode(0);
        result.setData(list);
        return result;
    }

    /**
     * 删除合同
     * @param contractDTO
     * @return
     */
    @RequestMapping("deleteContract")
    public Result deleteContract(ContractDTO contractDTO){
        Result result = new Result();
        dubboContract.deleteContract(contractDTO);
        return result;
    }
}
