package com.lym.config;

import com.lym.code.CORSAuthenticationFilter;
import com.lym.dubbo.DubboUser;
import com.lym.shiro.CustomRealm;
import com.lym.tool.SpringBeanFactoryUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.IRedisManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author LYM
 * @Description 安全配置类
 * @Date 2021/1/10
 * @Version v1.0.0
 **/
@Configuration
public class ShiroConfig {

    // 获取redis配置
    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public CustomRealm getCustomRealm(){
        CustomRealm myShiroRealm = new CustomRealm();
        return myShiroRealm;
    }


    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(DefaultWebSessionManager defaultWebSessionManager, SessionDAO redisSession, CustomRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入realm
        securityManager.setRealm(userRealm);
        // 设置了一个redisSession   前后端分离 存储 token
        defaultWebSessionManager.setSessionDAO(redisSession);
        //  改变了会话   注入到安全管理当中  前后端分离    自定义session管理 使用redis
        securityManager.setSessionManager(defaultWebSessionManager);

        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //登录
        shiroFilterFactoryBean.setLoginUrl("/Landlor/landlord/user/login.html");
        //首页
       // shiroFilterFactoryBean.setSuccessUrl("/index");
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/css/*", "anon");
        filterChainDefinitionMap.put("/js/*", "anon");
        filterChainDefinitionMap.put("/js/*/*", "anon");
        filterChainDefinitionMap.put("/js/*/*/*", "anon");
        filterChainDefinitionMap.put("/upload/**", "anon");
        filterChainDefinitionMap.put("/images/*/**", "anon");
        filterChainDefinitionMap.put("/layui/*", "anon");
        filterChainDefinitionMap.put("/layui/*/**", "anon");
        filterChainDefinitionMap.put("/treegrid/*", "anon");
        filterChainDefinitionMap.put("/treegrid/*/*", "anon");
        filterChainDefinitionMap.put("/fragments/*", "anon");
        filterChainDefinitionMap.put("/layout", "anon");
        filterChainDefinitionMap.put("/user/sendMsg", "anon");
        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/user/captcha", "anon");
        filterChainDefinitionMap.put("/user/saveUser", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/*/*", "authc");
        filterChainDefinitionMap.put("/*/*/*", "authc");
        filterChainDefinitionMap.put("/*/*/*/**", "authc");
        //登出
        filterChainDefinitionMap.put("/logout", "logout");
        //错误页面，认证不通过跳转
       // shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        //自定义拦截器
        Map<String, Filter> customFilterMap = new LinkedHashMap<>();
        customFilterMap.put("corsAuthenticationFilter", new CORSAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(customFilterMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    //注入权限管理
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    @Bean
    public SessionDAO redisSessionDAO(IRedisManager redisManager) {
        // 创建redisSession   这里面 应该就是 存储 shiro-session 的token了吧
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();

        //操作那个redis
        redisSessionDAO.setRedisManager(redisManager);
        // 用户的登录信息保存多久？ 7 天
        redisSessionDAO.setExpire(7 * 24 * 3600);
        //			redisSessionDAO.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //       redisSessionDAO.setKeySerializer(keySerializer); jdk
        //       redisSessionDAO.setValueSerializer(valueSerializer);jdk
        System.out.println("TOKEN缓存到Redis当中==============================================================");
//			System.out.println(redisSessionDAO.getKeySerializer());
//			System.out.println(redisSessionDAO.getValueSerializer());
//			System.out.println(redisSessionDAO.getSessionInMemoryEnabled());
//			System.out.println(redisSessionDAO.getSessionInMemoryTimeout());
        return redisSessionDAO;
    }


    /**
     * redis 数据库  连接池
     *
     * @return
     */
    @Bean
    public IRedisManager redisManager() {

        RedisManager redisManager = new RedisManager();
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 链接池的最量 20 ，并发特别大时，连接池的数据可以最大增加20个
        // 创建连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), 2000, redisProperties.getPassword());
        // 设置连接池
        redisManager.setJedisPool(jedisPool);
        return redisManager;
    }
}
