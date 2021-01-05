package dto;

import lombok.Data;

/**
 * @Author LYM
 * @Description 用户实体类
 * @Date 2020/12/26
 * @Version v1.0.0
 **/
@Data
public class UserDTO {
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
