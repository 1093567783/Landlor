package com.lym.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author LYM
 * @Description shiro仓库
 * @Date 2021/1/29
 * @Version v1.0.0
 **/
@ConfigurationProperties(prefix = "shiro")
@Data
public class ShiroProperties {
    /**
     * 加密方式
     */
    private String hashAlgorithmName = "md5";
    /**
     * 散列次数
     */
    private Integer hashIterations = 2;
    /**
     * 登陆URL
     */
    private String loginUrl;
    /**
     * 没有授权的跳转url
     */
    private String unauthorizedUrl;
    /**
     * 放行url
     */
    private String[] anonUrls;
    /**
     * 退出url
     */
    private String logoutUrl;
    /**
     * 拦截url
     */
    private String[] authcUrls;
}
