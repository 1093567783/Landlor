package com.lym.code;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LX
 * 创建时间： 2019/5/31. 10:25
 * 地点：广州
 * 目的: 过滤OPTIONS请求
 *      继承shiro 的form表单过滤器，对 OPTIONS 请求进行过滤。
 *      前后端分离项目中，由于跨域，会导致复杂请求，即会发送preflighted request，这样会导致在GET／POST等请求之前会先发一个OPTIONS请求，但OPTIONS请求并不带shiro
 *      的'authToken'字段（shiro的SessionId），即OPTIONS请求不能通过shiro验证，会返回未认证的信息。
 *
 * 备注说明： 需要在 shiroConfig 进行注册
 */
public class CORSAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 当用户访问未登陆资源时，会走的方法。
     * 返回true代表已登陆，不用处理
     * 返回false代表未登陆。提示前端
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code", -1);
        resultData.put("msg", "LYM提示您：登录认证失效，请重新登录!");
        PrintWriter out= response.getWriter();
        //使用fastjson的对象转化方法
        out.write(JSONObject.toJSON(resultData).toString());
        return false;
    }
}

