package com.lym.manager.contract;

import com.lym.mapper.contract.LandlordMapper;
import com.lym.model.contract.dto.LandlordDTO;
import com.lym.model.contract.vo.LandlordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LYM
 * @Description 房东管理
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Component
public class LandlordManager {
    @Autowired
    private LandlordMapper landlordMapper;

    /**
     * 获取所有房东
     * @param landlordDTO
     * @return
     */
    public List<LandlordVO> findAllLandlord(LandlordDTO landlordDTO) {
       return landlordMapper.findAllLandlord(landlordDTO);
    }

    /**
     * 保存房东
     * @param landlordDTO
     */
    public void saveLandlord(LandlordDTO landlordDTO) {
        landlordMapper.insertSelective(landlordDTO);
    }
}
