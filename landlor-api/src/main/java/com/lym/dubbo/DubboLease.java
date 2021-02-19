package com.lym.dubbo;

import com.lym.model.contract.dto.LeaseDTO;
import com.lym.model.contract.vo.LeaseVO;

import java.util.List;

public interface DubboLease {
    /**
     * 保存租赁信息
     * @param leaseDTO
     */
    void saveLease(LeaseDTO leaseDTO);

    /**
     * 查询租赁信息
     * @param leaseDTO
     * @return
     */
    List<LeaseVO> findAllLease(LeaseDTO leaseDTO);
}
