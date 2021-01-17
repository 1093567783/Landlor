package com.lym.model.user.vo;



import com.lym.model.common.BaseEntityDTO;
import com.lym.model.shiro.Role;
import lombok.Data;

import java.io.Serializable;
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
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}
