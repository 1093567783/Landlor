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

    /**
     * 保存租客
     * @param customerDTO
     */
    void saveCustomer(CustomerDTO customerDTO);

    /**
     * 删除租客
     * @param customerDTO
     */
    void deleteCustomer(CustomerDTO customerDTO);

    /**
     * 修改租客
     * @param customerDTO
     */
    void updateCustomer(CustomerDTO customerDTO);
}
