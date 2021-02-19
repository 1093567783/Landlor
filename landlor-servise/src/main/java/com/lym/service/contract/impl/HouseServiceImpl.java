package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboHouse;
import com.lym.manager.contract.HouseManager;
import com.lym.manager.contract.LandlordManager;
import com.lym.model.contract.dto.HouseDTO;
import com.lym.model.contract.vo.HouseVO;
import com.lym.model.contract.vo.LandlordVO;
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
    @Autowired
    private LandlordManager landlordManager;

    @Override
    public List<HouseVO> findAllHouse(HouseDTO houseDTO) {
        List<HouseVO> allHouse = houseManager.findAllHouse(houseDTO);
        for (HouseVO houseVO:allHouse) {
            LandlordVO landlord = landlordManager.getLandlordById(houseVO.getLandlordId());
            if(landlord == null){
                houseVO.setLandlordName("房东不存在");
            }else {
                houseVO.setLandlordName(landlord.getName());
            }
        }
        return allHouse;
    }

    /**
     * 保存房源
     * @param houseDTO
     */
    @Override
    public void saveHouse(HouseDTO houseDTO) {
        houseManager.saveHouse(houseDTO);
    }

    /**
     * 删除房源
     * @param houseDTO
     */
    @Override
    public void deleteHouse(HouseDTO houseDTO) {
        houseManager.deleteHouse(houseDTO);
    }

    /**
     * 修改房源
     * @param houseDTO
     */
    @Override
    public void updateHouse(HouseDTO houseDTO) {
        houseManager.updateHouse(houseDTO);
    }


}
