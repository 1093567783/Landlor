package com.lym.model.user.dto;

import org.hibernate.validator.constraints.NotBlank;
import com.lym.model.common.BaseEntityDTO;
import com.lym.model.shiro.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Author LYM
 * @Description 用户实体类
 * @Date 2020/12/26
 * @Version v1.0.0
 **/
@Data
public class UserDTO extends BaseEntityDTO implements Serializable {
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
     * 用户账户
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 当前密码
     */
    private String oldPassword;
    /**
     * 用户密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 确认密码
     */
    private String rePass;
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
    private Set<Role> roles;
}
