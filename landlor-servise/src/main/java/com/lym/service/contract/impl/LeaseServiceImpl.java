package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboLease;
import com.lym.service.contract.LeaseService;

/**
 * @Author LYM
 * @Description 租赁实现
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboLease.class, delay = -1, retries = 0)
public class LeaseServiceImpl implements LeaseService{
}
