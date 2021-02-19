package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.manager.contract.ContractManager;
import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.vo.ContractVO;
import com.lym.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 合同接口实体
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboContract.class, delay = -1, retries = 0)
public class ContractServiceImpl implements ContractService{
    @Autowired
    private ContractManager contractManager;

    /**
     * 保存合同
     * @param contractDTO
     */
    @Override
    public ContractDTO saveContract(ContractDTO contractDTO) {
       return contractManager.saveContract(contractDTO);
    }

    /**
     * 查找合同
     * @param contractDTO
     * @return
     */
    @Override
    public List<ContractVO> findAllContract(ContractDTO contractDTO) {
        return contractManager.findAllContract(contractDTO);
    }

    /**
     * 删除合同
     * @param contractDTO
     */
    @Override
    public void deleteContract(ContractDTO contractDTO) {
        contractManager.deleteContract(contractDTO);
    }

    /**
     *
     * @param contractDTO
     * @return
     */
    @Override
    public ContractVO getContractById(ContractDTO contractDTO) {
        return contractManager.getContractById(contractDTO);
    }
}
