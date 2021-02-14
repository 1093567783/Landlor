package com.lym.mapper.contract;

import com.lym.model.contract.dto.LandlordDTO;
import com.lym.model.contract.vo.LandlordVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LandlordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LandlordDTO record);

    int insertSelective(LandlordDTO record);

    LandlordVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LandlordDTO record);

    int updateByPrimaryKey(LandlordDTO record);
}