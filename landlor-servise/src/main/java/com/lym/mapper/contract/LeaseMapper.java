package com.lym.mapper.contract;

import com.lym.model.contract.dto.LeaseDTO;
import com.lym.model.contract.vo.LeaseVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaseDTO record);

    int insertSelective(LeaseDTO record);

    LeaseVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaseDTO record);

    int updateByPrimaryKey(LeaseDTO record);
}