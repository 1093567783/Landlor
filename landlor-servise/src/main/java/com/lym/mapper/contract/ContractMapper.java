package com.lym.mapper.contract;

import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.vo.ContractVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author LYM
 * @Description 合同数据持久层
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Mapper
public interface ContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContractDTO record);

    int insertSelective(ContractDTO record);

    ContractVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContractDTO record);

    int updateByPrimaryKey(ContractDTO record);

    List<ContractVO> findAllContract(ContractDTO contractDTO);

}
