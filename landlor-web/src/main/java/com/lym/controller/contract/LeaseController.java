package com.lym.controller.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboLease;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.LeaseDTO;
import com.lym.model.contract.vo.LeaseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LYM
 * @Description 租赁信息管理
 * @Date 2021/2/18
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/lease/")
public class LeaseController {
    @Reference
    private DubboLease dubboLease;

    @RequestMapping("findAllLease")
    public Result findAllLease(LeaseDTO leaseDTO){
        Result result = new Result();
        List<LeaseVO> leaseVOS = dubboLease.findAllLease(leaseDTO);
        result.setCount(leaseVOS.get(0).getCount());
        result.setData(leaseVOS);
        result.setCode(0);
        return result;
    }
}
