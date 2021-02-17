package com.lym.dubbo;

import com.lym.model.contract.dto.LandlordDTO;
import com.lym.model.contract.vo.LandlordVO;

import java.util.List;

public interface DubboLandlord {
    /**
     * 获取所有房东
     * @param landlordDTO
     * @return
     */
    List<LandlordVO> findAllLandlord(LandlordDTO landlordDTO);

    /**
     * 保存房东
     * @param landlordDTO
     */
    void saveLandlord(LandlordDTO landlordDTO);

    /**
     * 删除房东
     * @param landlordDTO
     */
    void deleteLandlord(LandlordDTO landlordDTO);

    /**
     * 修改房东
     * @param landlordDTO
     */
    void updateLandlord(LandlordDTO landlordDTO);
}
