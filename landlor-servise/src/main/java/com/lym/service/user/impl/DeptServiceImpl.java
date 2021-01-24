package com.lym.service.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboDept;
import com.lym.manager.user.UserManager;
import com.lym.mapper.user.DepartmentMapper;
import com.lym.model.user.vo.DepartmentVO;
import com.lym.service.user.DeptService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author LYM
 * @Description 部门接口实现
 * @Date 2021/1/24
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboDept.class, delay = -1, retries = 0)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;
    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<DepartmentVO> loadAllDept() {
        return departmentMapper.loadAllDept();
    }
}
