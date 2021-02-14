package com.lym.mapper.contract;

import com.lym.model.contract.dto.HouseDTO;
import com.lym.model.contract.vo.HouseVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseDTO record);

    int insertSelective(HouseDTO record);

    HouseVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseDTO record);

    int updateByPrimaryKey(HouseDTO record);
}