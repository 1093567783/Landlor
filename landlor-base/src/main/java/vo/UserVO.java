package vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author LYM
 * @Description 用户回显实体
 * @Date 2020/12/26
 * @Version v1.0.0
 **/
@Data
public class UserVO implements Serializable {
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
