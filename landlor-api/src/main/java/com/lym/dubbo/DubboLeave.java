package com.lym.dubbo;

import com.lym.model.leave.LeaveDTO;
import com.lym.model.leave.LeaveVO;

import java.util.List;

public interface DubboLeave {
    /**
     * 查询我的假单
     * @param id
     * @return
     */
    List<LeaveVO> findLeaveListByUserId(Byte id);

    void saveStartLeave(LeaveDTO leavebill);

    LeaveVO findLeaveBillById(long id);

    void deleteLeaveBillById(long billId);
}
