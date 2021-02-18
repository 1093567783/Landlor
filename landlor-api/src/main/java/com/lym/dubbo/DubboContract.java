package com.lym.dubbo;

import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.vo.ContractVO;

import java.util.List;

public interface DubboContract {
    void saveContract(ContractDTO contractDTO);

    List<ContractVO> findAllContract(ContractDTO contractDTO);

    void deleteContract(ContractDTO contractDTO);
}
