package com.lym.service.leave.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboLeave;
import com.lym.model.leave.LeaveDTO;
import com.lym.model.leave.LeaveVO;
import com.lym.service.leave.LeaveService;
import lombok.Data;

import java.util.List;

/**
 * @Author LYM
 * @Description 假单服务实现
 * @Date 2021/2/20
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboLeave.class, delay = -1, retries = 0)
public class LeaveServiceImpl implements LeaveService{
    @Override
    public List<LeaveVO> findLeaveListByUserId(Byte id) {
        return null;
    }

    @Override
    public void saveStartLeave(LeaveDTO leavebill) {

    }

    @Override
    public LeaveVO findLeaveBillById(long id) {
        return null;
    }

    @Override
    public void deleteLeaveBillById(long billId) {

    }
}
