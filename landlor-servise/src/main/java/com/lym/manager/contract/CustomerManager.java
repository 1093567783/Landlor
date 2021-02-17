package com.lym.manager.contract;

import com.lym.mapper.contract.CustomerMapper;
import com.lym.model.contract.dto.CustomerDTO;
import com.lym.model.contract.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LYM
 * @Description 租客管理
 * @Date 2021/2/8
 * @Version v1.0.0
 **/
@Component
public class CustomerManager {

    @Autowired
    private CustomerMapper customerMapper;
    /**
     * 获取所有租客
     * @param customerDTO
     * @return
     */
    public List<CustomerVO> findAllCustomer(CustomerDTO customerDTO) {
        List<CustomerVO> allCustomer = customerMapper.findAllCustomer(customerDTO);
        return allCustomer;
    }

    /**
     * 保存租客
     * @param customerDTO
     */
    public void saveCustomer(CustomerDTO customerDTO) {
        customerMapper.insertSelective(customerDTO);
    }

    /**
     * 删除租客
     * @param customerDTO
     */
    public void deleteCustomer(CustomerDTO customerDTO) {
        customerMapper.deleteByPrimaryKey(customerDTO.getId());
    }

    /**
     * 修改租客
     * @param customerDTO
     */
    public void updateCustomer(CustomerDTO customerDTO) {
        customerMapper.updateByPrimaryKeySelective(customerDTO);
    }
}
