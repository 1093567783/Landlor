package com.lym.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lym.dubbo.DubboRole;
import com.lym.model.common.Constant;
import com.lym.model.common.DataGridView;
import com.lym.model.common.Result;
import com.lym.model.user.dto.RoleDTO;
import com.lym.model.user.vo.RoleVO;
import com.lym.model.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

    /**
     * 查询所有可用角色
     * @param roleDTO
     * @return
     */
    @RequestMapping("loadAllAvailableRoleNoPage")
    public DataGridView loadAllAvailableRoleNoPage(RoleDTO roleDTO){
        roleDTO.setAvailable(Constant.AVAILABLE_TRUE);
        return dubboRole.loadAllAvailableRoleNoPage(roleDTO);
    }

    /**
     * 加载角色数据
     *
     * @param roleDTO
     * @return
     */
    @GetMapping("loadAllRole")
    public Result loadAllRole(RoleDTO roleDTO) {
        Result result = new Result();
        List<RoleVO> list = this.dubboRole.queryAllRole(roleDTO);
        result.setCode(0);
        result.setData(list);
        return result;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @PostMapping("addRole")
    public Result addRole(RoleDTO role) {
        Result result = new Result();
        try {
            // 设置添加时间
            role.setCreatetime(new Date());
            role.setAvailable(Constant.AVAILABLE_TRUE);
            this.dubboRole.saveRole(role);
            return result;
        } catch (Exception e) {
            return result.setError(400,"异常");
        }
    }


    /**
     * 修改
     *
     * @param role
     * @return
     */
    @PostMapping("updateRole")
    public Result updateRole(RoleDTO role) {
        Result result = new Result();
        try {
            this.dubboRole.updateRole(role);
            return result;
        } catch (Exception e) {
            return result.setError(400,"异常");
        }
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping("deleteRole")
    public Result deleteRole(Integer id) {
        Result result = new Result();
        try {
            this.dubboRole.deleteRole(id);
            return result;
        } catch (Exception e) {
            return result.setError(400,"异常");
        }
    }


    /**
     * 根据角色ID查询当前角色已拥有的菜单id集合
     *
     * @param id
     * @return
     */
    @GetMapping("queryMenuIdsByRid")
    public Object queryMenuIdsByRid(Integer id) {
        List<Integer> menus = this.dubboRole.queryMenuIdsByRid(id);
        return new DataGridView(menus);
    }


    /**
     * 保存角色菜单 关系
     * @param rid
     * @param mids
     * @return
     */
    @PostMapping("saveRoleMenu")
    public Result saveRoleMenu(Integer rid,Integer[] mids) {
        Result result = new Result();
        try {
            this.dubboRole.saveRoleMenu(rid,mids);
            return result;
        } catch (Exception e) {
            return result.setError(400,"异常");
        }
    }
}
