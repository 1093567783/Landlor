package com.lym.controller.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboCustomer;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.CustomerDTO;
import com.lym.model.contract.vo.CustomerVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LYM
 * @Description 租客控制层
 * @Date 2021/2/14
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/customer/")
public class CustomerController {
    @Reference
    private DubboCustomer dubboCustomer;

    @RequestMapping("findAllCustomer")
    public Result findAllCustomer(CustomerDTO customerDTO){
        Result result = new Result();
        List<CustomerVO> list = dubboCustomer.findAllCustomer(customerDTO);
        return result;
    }
}
