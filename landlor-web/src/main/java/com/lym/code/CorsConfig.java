package com.lym.code;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author LYM
 * @Description 解决跨域问题
 * @Date 2021/1/9
 * @Version v1.0.0
 **/
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600)
        ;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
//        registry.addResourceHandler("/upload1/**").addResourceLocations(filePath);
//        super.addResourceHandlers(registry);
//        System.out.println(filePath);
    }

}
