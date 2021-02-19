package com.lym.mapper.contract;

import com.lym.model.contract.dto.NoticeDTO;
import com.lym.model.contract.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NoticeDTO record);

    int insertSelective(NoticeDTO record);

    NoticeVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoticeDTO record);

    int updateByPrimaryKey(NoticeDTO record);
}
