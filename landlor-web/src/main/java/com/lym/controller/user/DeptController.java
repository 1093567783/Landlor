package com.lym.controller.user;

import com.lym.dubbo.DubboDept;
import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.model.common.Result;
import com.lym.model.user.vo.DepartmentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LYM
 * @Description 部门控制层
 * @Date 2021/1/24
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/dept/")
@Slf4j
public class DeptController {

    @Reference
    private DubboDept dubboDept;

    @RequestMapping("loadAllDept")
    public Result<Object> loadAllDept(){
        Result<Object> result = new Result();
       List<DepartmentVO> list = dubboDept.loadAllDept();
       result.setData(list);
       return result;
    }
}
