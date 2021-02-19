package com.lym.manager.contract;

import com.lym.mapper.contract.LeaseMapper;
import com.lym.model.contract.dto.LeaseDTO;
import com.lym.model.contract.vo.LeaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LYM
 * @Description 租赁管理
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Component
public class LeaseManager {
    @Autowired
   private LeaseMapper leaseMapper;

    /**
     * 保存租赁信息
     * @param leaseDTO
     */
    public void saveLease(LeaseDTO leaseDTO) {
        leaseMapper.insertSelective(leaseDTO);
    }

    /**
     * 查询租赁信息
     * @param leaseDTO
     * @return
     */
    public List<LeaseVO> findAllLease(LeaseDTO leaseDTO) {
       return leaseMapper.findAllLease(leaseDTO);
    }
}
