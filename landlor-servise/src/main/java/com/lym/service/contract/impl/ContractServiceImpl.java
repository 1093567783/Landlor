package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.service.contract.ContractService;

/**
 * @Author LYM
 * @Description 合同接口实体
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboContract.class, delay = -1, retries = 0)
public class ContractServiceImpl implements ContractService{
}
