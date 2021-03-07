package com.lym.controller.contract;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboLandlord;
import com.lym.model.common.Result;
import com.lym.model.contract.dto.LandlordDTO;
import com.lym.model.contract.vo.LandlordVO;
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
 * @Description 房东控制层
 * @Date 2021/2/14
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/landlord/")
public class LandlordController {
    @Reference
    private DubboLandlord dubboLandlord;

    /**
     * 获取所有房东
     * @param landlordDTO
     * @return
     */
    @RequestMapping("findAllLandlord")
    public Result findAllLandlord(LandlordDTO landlordDTO){
        Result result = new Result();
        List<LandlordVO> list = dubboLandlord.findAllLandlord(landlordDTO);
        result.setData(list);
        result.setCode(0);
        return result;
    };

    /**
     * 保存房东
     * @param landlordDTO
     * @return
     */
    @RequestMapping("saveLandlord")
    public Result saveLandlord(@RequestBody @Valid LandlordDTO landlordDTO,BindingResult validMsg){
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UserVO userVO = (UserVO) subject.getPrincipal();
        landlordDTO.setJoinTime(new Date());
        landlordDTO.setUserId(userVO.getId().intValue());
        dubboLandlord.saveLandlord(landlordDTO);
        result.setMsg("保存成功");
        return result;
    }

    /**
     * 删除房东
     * @param landlordDTO
     * @return
     */
    @RequestMapping("deleteLandlord")
    public Result deleteLandlord(LandlordDTO landlordDTO){
        Result result = new Result();
        dubboLandlord.deleteLandlord(landlordDTO);
        result.setMsg("删除成功");
        return result;
    }

    /**
     * 修改房东
     * @param landlordDTO
     * @return
     */
    @RequestMapping("updateLandlord")
    public Result updateLandlord(LandlordDTO landlordDTO){
        Result result = new Result();
        dubboLandlord.updateLandlord(landlordDTO);
        result.setMsg("修改成功");
        return result;
    };
}
