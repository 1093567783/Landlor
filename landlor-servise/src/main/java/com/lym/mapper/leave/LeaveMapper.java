package com.lym.mapper.leave;


import com.lym.model.leave.LeaveDTO;
import com.lym.model.leave.LeaveVO;

public interface LeaveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LeaveDTO record);

    int insertSelective(LeaveDTO record);

    LeaveVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaveDTO record);

    int updateByPrimaryKey(LeaveDTO record);
}