package com.lym.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboRole;
import com.lym.model.common.Constant;
import com.lym.model.common.DataGridView;
import com.lym.model.user.dto.RoleDTO;
import com.lym.model.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LYM
 * @Description 角色控制类
 * @Date 2021/1/26
 * @Version v1.0.0
 **/
@RestController
@RequestMapping("/role/")
@Slf4j
public class RoleController {
    @Reference
    private DubboRole dubboRole;

    @RequestMapping("loadAllAvailableRoleNoPage")
    public DataGridView loadAllAvailableRoleNoPage(RoleDTO roleDTO){
        roleDTO.setAvailable(Constant.AVAILABLE_TRUE);
        //UserVO userVO = (UserVO) SecurityUtils.getSubject().getPrincipal();
        //roleDTO.setUserId(userVO.getId().intValue());
        return dubboRole.loadAllAvailableRoleNoPage(roleDTO);
    }
}
