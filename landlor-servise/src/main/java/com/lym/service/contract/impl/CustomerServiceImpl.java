package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboCustomer;
import com.lym.manager.contract.CustomerManager;
import com.lym.model.contract.dto.CustomerDTO;
import com.lym.model.contract.vo.CustomerVO;
import com.lym.service.contract.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 租客实现类
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboCustomer.class, delay = -1, retries = 0)
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerManager customerManager;

    /**
     * 获取所有租客
     * @param customerDTO
     * @return
     */
    @Override
    public List<CustomerVO> findAllCustomer(CustomerDTO customerDTO) {
        return customerManager.findAllCustomer(customerDTO);
    }
}
