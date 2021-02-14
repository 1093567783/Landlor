package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboHouse;
import com.lym.service.contract.HouseService;

/**
 * @Author LYM
 * @Description 房源实现类
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboHouse.class, delay = -1, retries = 0)
public class HouseServiceImpl implements HouseService{
}
