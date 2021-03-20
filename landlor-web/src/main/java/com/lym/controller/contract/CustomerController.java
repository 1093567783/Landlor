package com.lym.controller.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboCustomer;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.CustomerDTO;
import com.lym.model.contract.vo.CustomerVO;
import com.lym.model.user.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @Author LYM
 * @Description 租客控制层
 * @Date 2021/2/14
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/customer/")
public class CustomerController {
    @Reference
    private DubboCustomer dubboCustomer;

    /**
     * 获取所有租客
     * @param customerDTO
     * @return
     */
    @RequestMapping("findAllCustomer")
    public Result findAllCustomer(CustomerDTO customerDTO){
        Result result = new Result();
        List<CustomerVO> list = dubboCustomer.findAllCustomer(customerDTO);
        result.setCount(list.get(0).getCount());
        result.setData(list);
        result.setCode(0);
        return result;
    }

    /**
     * 保存租客
     * @param customerDTO
     * @param validMsg
     * @return
     */
    @RequestMapping("saveCustomer")
    public Result saveCustomer(@RequestBody @Valid CustomerDTO customerDTO,BindingResult validMsg){
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        customerDTO.setJoinTime(new Date());
        customerDTO.setUserId(userVO.getId().intValue());
        customerDTO.setUpdateTime(new Date());
        dubboCustomer.saveCustomer(customerDTO);
        result.setMsg("添加成功");
        return result;
    }

    /**
     * 删除租户
     * @param customerDTO
     * @return
     */
    @RequestMapping("deleteCustomer")
    public Result deleteCustomer(CustomerDTO customerDTO){
        Result result = new Result();
        dubboCustomer.deleteCustomer(customerDTO);
        result.setMsg("删除成功");
        return result;
    };

    /**
     * 修改租客
     * @param customerDTO
     * @return
     */
    @RequestMapping("updateCustomer")
    public Result updateCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        Result result = new Result();
        dubboCustomer.updateCustomer(customerDTO);
        result.setMsg("修改成功");
        return result;
    }
}
