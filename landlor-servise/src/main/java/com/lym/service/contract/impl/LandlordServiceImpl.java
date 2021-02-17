package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboLandlord;
import com.lym.manager.contract.LandlordManager;
import com.lym.model.contract.dto.LandlordDTO;
import com.lym.model.contract.vo.LandlordVO;
import com.lym.service.contract.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 房东实现
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboLandlord.class, delay = -1, retries = 0)
public class LandlordServiceImpl implements LandlordService{

    @Autowired
    private LandlordManager landlordManager;

    /**
     * 获取所有房东
     * @param landlordDTO
     * @return
     */
    @Override
    public List<LandlordVO> findAllLandlord(LandlordDTO landlordDTO) {
        return landlordManager.findAllLandlord(landlordDTO);
    }

    /**
     * 保存房东
     * @param landlordDTO
     */
    @Override
    public void saveLandlord(LandlordDTO landlordDTO) {
        landlordManager.saveLandlord(landlordDTO);
    }

    /**
     * 删除房东
     * @param landlordDTO
     */
    @Override
    public void deleteLandlord(LandlordDTO landlordDTO) {
        landlordManager.deleteLandlord(landlordDTO);
    }

    @Override
    public void updateLandlord(LandlordDTO landlordDTO) {
        landlordManager.updateLandlord(landlordDTO);
    }
}
