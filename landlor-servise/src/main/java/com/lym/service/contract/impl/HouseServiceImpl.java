package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboHouse;
import com.lym.manager.contract.HouseManager;
import com.lym.model.contract.dto.HouseDTO;
import com.lym.model.contract.vo.HouseVO;
import com.lym.service.contract.HouseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 房源实现类
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboHouse.class, delay = -1, retries = 0)
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseManager houseManager;
    @Override
    public List<HouseVO> findAllHouse(HouseDTO houseDTO) {
        return houseManager.findAllHouse(houseDTO);
    }

    @Override
    public void saveHouse(HouseDTO houseDTO) {
        houseManager.saveHouse(houseDTO);
    }
}
