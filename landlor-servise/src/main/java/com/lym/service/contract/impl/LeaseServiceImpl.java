package com.lym.service.contract.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboContract;
import com.lym.dubbo.DubboLease;
import com.lym.manager.contract.LeaseManager;
import com.lym.model.contract.dto.LeaseDTO;
import com.lym.model.contract.vo.LeaseVO;
import com.lym.service.contract.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 租赁实现
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboLease.class, delay = -1, retries = 0)
public class LeaseServiceImpl implements LeaseService{
    @Autowired
    private LeaseManager leaseManager;
    /**
     * 保存租赁信息
     * @param leaseDTO
     */
    @Override
    public void saveLease(LeaseDTO leaseDTO) {
        leaseManager.saveLease(leaseDTO);
    }

    /**
     * 查询租赁信息
     * @param leaseDTO
     * @return
     */
    @Override
    public List<LeaseVO> findAllLease(LeaseDTO leaseDTO) {
        return leaseManager.findAllLease(leaseDTO);
    }
}
