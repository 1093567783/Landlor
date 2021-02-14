package com.lym.mapper.contract;

import com.lym.model.contract.dto.CustomerDTO;
import com.lym.model.contract.vo.CustomerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerDTO record);

    int insertSelective(CustomerDTO record);

    CustomerVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerDTO record);

    int updateByPrimaryKey(CustomerDTO record);

    List<CustomerVO> findAllCustomer(CustomerDTO record);
}