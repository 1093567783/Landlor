package com.lym.controller.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboHouse;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.HouseDTO;
import com.lym.model.contract.vo.HouseVO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author LYM
 * @Description 房源控制层
 * @Date 2021/2/14
 * @Version v1.0.0
 **/
@RequestMapping("/house/")
@RestController
public class HouseController {
    @Reference
    private DubboHouse dubboHouse;

    /**
     * 获取所有房源
     * @param houseDTO
     * @return
     */
    @RequestMapping("findAllHouse")
    public Result findAllHouse(HouseDTO houseDTO){
        Result result = new Result();
        List<HouseVO> list = dubboHouse.findAllHouse(houseDTO);
        result.setData(list);
        result.setCode(0);
        return result;
    };
    @RequestMapping("saveHouse")
    public Result saveHouse(@RequestBody @Valid HouseDTO houseDTO,BindingResult validMsg){
        Result result = new Result();
        dubboHouse.saveHouse(houseDTO);
        return result;
    }
}
