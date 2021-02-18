package com.lym.manager.contract;

import com.lym.mapper.contract.ContractMapper;
import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.vo.ContractVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LYM
 * @Description 合同管理
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Component
public class ContractManager {
    @Autowired
   private ContractMapper contractMapper;

    public void saveContract(ContractDTO contractDTO) {
        contractMapper.insertSelective(contractDTO);
    }

    public List<ContractVO> findAllContract(ContractDTO contractDTO) {
        List<ContractVO> list = contractMapper.findAllContract(contractDTO);
        return list;
    }
}
