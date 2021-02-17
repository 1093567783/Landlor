package com.lym.dubbo;

import com.lym.model.contract.dto.HouseDTO;
import com.lym.model.contract.vo.HouseVO;

import java.util.List;

public interface DubboHouse {

    /**
     * 获取所有房源
     * @param houseDTO
     * @return
     */
    List<HouseVO> findAllHouse(HouseDTO houseDTO);

    /**
     * 保存房源
     * @param houseDTO
     */
    void saveHouse(HouseDTO houseDTO);

    /**
     * 删除房源
     * @param houseDTO
     */
    void deleteHouse(HouseDTO houseDTO);

    /**
     * 修改房源
     * @param houseDTO
     */
    void updateHouse(HouseDTO houseDTO);
}
