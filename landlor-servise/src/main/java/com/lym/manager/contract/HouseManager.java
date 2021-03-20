package com.lym.manager.contract;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lym.mapper.contract.HouseMapper;
import com.lym.model.contract.dto.HouseDTO;
import com.lym.model.contract.vo.HouseVO;
import com.lym.model.contract.vo.LandlordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LYM
 * @Description 房源管理
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Component
public class HouseManager {
    @Autowired
    private HouseMapper houseMapper;

    /**
     * 获取所有房源
     * @param houseDTO
     * @return
     */
    public List<HouseVO> findAllHouse(HouseDTO houseDTO) {
        PageHelper.startPage(houseDTO.getPage(),houseDTO.getLimit());
        List<HouseVO> allHouse = houseMapper.findAllHouse(houseDTO);

        PageInfo<HouseVO> pageInfo = new PageInfo<>(allHouse);
        allHouse.get(0).setCount(pageInfo.getTotal());
        return allHouse;
    }

    /**
     * 保存房源
     * @param houseDTO
     */
    public void saveHouse(HouseDTO houseDTO) {
        houseMapper.insertSelective(houseDTO);
    }

    /**
     * 删除房源
     * @param houseDTO
     */
    public void deleteHouse(HouseDTO houseDTO) {
        houseMapper.deleteByPrimaryKey(houseDTO.getId());
    }

    /**
     * 修改房源
     * @param houseDTO
     */
    public void updateHouse(HouseDTO houseDTO) {
        houseMapper.updateByPrimaryKeySelective(houseDTO);
    }
}
