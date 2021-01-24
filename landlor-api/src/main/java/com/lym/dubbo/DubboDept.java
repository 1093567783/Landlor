package com.lym.dubbo;

import com.lym.model.user.vo.DepartmentVO;

import java.util.List;

/**
 * @Author LYM
 * @Description 部门接口
 * @Date 2021/1/24
 * @Version v1.0.0
 **/
public interface DubboDept {

    public List<DepartmentVO> loadAllDept();
}
