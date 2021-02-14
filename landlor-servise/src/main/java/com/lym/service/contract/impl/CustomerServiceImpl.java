package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboCustomer;
import com.lym.service.contract.CustomerService;

/**
 * @Author LYM
 * @Description 租客实现类
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboCustomer.class, delay = -1, retries = 0)
public class CustomerServiceImpl implements CustomerService{
}
