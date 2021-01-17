package com.lym.model.user.dto;

import com.lym.model.common.BaseEntityDTO;
import lombok.Data;

import java.io.Serializable;

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
}
