package com.lym.dubbo;

import com.lym.model.contract.dto.CustomerDTO;
import com.lym.model.contract.vo.CustomerVO;

import java.util.List;

public interface DubboCustomer {
    /**
     * 获取所有租客
     * @param customerDTO
     * @return
     */
    List<CustomerVO> findAllCustomer(CustomerDTO customerDTO);
}
