package com.lym.controller.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboLease;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.dto.LeaseDTO;
import com.lym.model.contract.vo.ContractVO;
import com.lym.model.user.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
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

    @Reference
    private DubboLease dubboLease;
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
        if(!StringUtils.isEmpty(contractDTO.getEndTimeStr()) ){
            Date end = sdf.parse(contractDTO.getEndTimeStr());
            contractDTO.setEndTime(end);
        }
        contractDTO.setStartTime(start);
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        contractDTO.setJoinTime(new Date());
        contractDTO.setUserId(userVO.getId().intValue());
        contractDTO.setUpdateTime(new Date());
        ContractDTO contract = dubboContract.saveContract(contractDTO);
        LeaseDTO leaseDTO = setLease(contract);
        dubboLease.saveLease(leaseDTO);
        return result;
    }

    /**
     * 设置租赁信息
     * @param contractDTO
     * @return
     */
    private LeaseDTO setLease(ContractDTO contractDTO){
        LeaseDTO leaseDTO = new LeaseDTO();
        leaseDTO.setContractId(contractDTO.getId());
        leaseDTO.setCustomerId(contractDTO.getCustomerId());
        leaseDTO.setHouseId(contractDTO.getHouseId());
        leaseDTO.setJoinTime(new Date());
        leaseDTO.setUserId(contractDTO.getUserId());
        leaseDTO.setUpdateTime(new Date());
        return leaseDTO;
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

    @RequestMapping("getContractById")
    public Result getContractById(ContractDTO contractDTO){
        Result result = new Result();
        ContractVO contractVO = dubboContract.getContractById(contractDTO);
        System.out.println(contractVO);
        result.setData(contractVO);
        result.setCode(0);
        return result;
    }
}
