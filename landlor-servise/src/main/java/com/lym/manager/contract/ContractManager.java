package com.lym.manager.contract;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lym.mapper.contract.ContractMapper;
import com.lym.model.contract.dto.ContractDTO;
import com.lym.model.contract.vo.ContractVO;
import com.lym.model.contract.vo.CustomerVO;
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

    public ContractDTO saveContract(ContractDTO contractDTO) {
        contractMapper.insertSelective(contractDTO);
        System.out.println(contractDTO);
        return contractDTO;
    }

    public List<ContractVO> findAllContract(ContractDTO contractDTO) {
        PageHelper.startPage(contractDTO.getPage(),contractDTO.getLimit());
        List<ContractVO> list = contractMapper.findAllContract(contractDTO);

        PageInfo<ContractVO> pageInfo = new PageInfo<>(list);
        list.get(0).setCount(pageInfo.getTotal());
        return list;
    }

    public ContractVO getContractById(ContractDTO contractDTO) {
        ContractVO contractVO = contractMapper.selectByPrimaryKey(contractDTO.getId());
        return contractVO;
    }

    public void deleteContract(ContractDTO contractDTO) {
        contractMapper.deleteByPrimaryKey(contractDTO.getId());
    }

    public void updateByPrimaryKeySelective(ContractDTO contractDTO){
        contractMapper.updateByPrimaryKeySelective(contractDTO);
    }
}
