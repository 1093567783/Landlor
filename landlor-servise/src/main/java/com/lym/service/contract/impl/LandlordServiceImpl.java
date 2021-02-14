package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboLandlord;
import com.lym.service.contract.LandlordService;

/**
 * @Author LYM
 * @Description 房东实现
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboLandlord.class, delay = -1, retries = 0)
public class LandlordServiceImpl implements LandlordService{
}
