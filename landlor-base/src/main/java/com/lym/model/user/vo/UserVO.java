package com.lym.model.user.vo;



import com.lym.model.common.BaseEntityDTO;
import com.lym.model.shiro.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Author LYM
 * @Description 用户回显实体
 * @Date 2020/12/26
 * @Version v1.0.0
 **/
@Data
public class UserVO extends BaseEntityDTO implements Serializable {
    /**
     * 用户id
     */
    private Byte id;
    /**
     * 角色id
     */
    private Byte roleId;
    /**部门id*/
    private Byte deptId;
    /**部门名称*/
    private String deptName;
    /**
     * 流程使用的上级id
     */
    private Byte managerId;
    /**
     * 用户账户
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 用户头像
     */
    private String picture;

    /**电话*/
    private String phone;

    /**电子邮箱*/
    private String email;

    /**性别*/
    private String sex;

    /**创建时间*/
    private Date joinTime;

    /**修改时间*/
    private Date updateTime;

    /**
     * 用户对应的角色集合
     */
    private List<Role> roles;
}
