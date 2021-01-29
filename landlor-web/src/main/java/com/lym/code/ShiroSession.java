package com.lym.code;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author ：LX
 * 创建时间： 2019/5/30. 18:08
 * 地点：广州
 * 目的: shiro 的 session 管理
 *      自定义session规则，实现前后分离，在跨域等情况下使用token 方式进行登录验证才需要，否则没必须使用本类。
 *      shiro默认使用 ServletContainerSessionManager 来做 session 管理，它是依赖于浏览器的 cookie 来维护 session 的,调用 storeSessionId  方法保存sesionId 到 cookie中
 *      为了支持无状态会话，我们就需要继承 DefaultWebSessionManager
 *      自定义生成sessionId 则要实现 SessionIdGenerator
 * 备注说明：
 */
@Configuration
public class ShiroSession extends DefaultWebSessionManager {

    private static final String TOKEN_HEADER = "TOKEN";

    /**
     * 重写getSessionId方法
     * 这里主要是进行判断 请求当中有没有Token
     * 没有则立马生成一个给到出去
     * 有则在请求头当中拿
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        System.out.println("获取当前请求地址:" + httpServletRequest.getRequestURI());
        // 这里与前端项目结合 吧token存储到 请求头里面
        //从头里面得到请求TOKEN 如果不存在就生成一个
        String header = WebUtils.toHttp(request).getHeader(TOKEN_HEADER);
        System.out.println("获取TOKEN:" + header);
        if (StringUtils.hasText(header)) {
            return header;
        }
        return UUID.randomUUID().toString();
    }

}