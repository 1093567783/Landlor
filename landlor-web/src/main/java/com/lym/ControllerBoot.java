package com.lym;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LYM
 * @Description 服务启动类
 * @Date 2020/12/28
 * @Version v1.0.0
 **/
@SpringBootApplication(scanBasePackages = "com.lym")
@DubboComponentScan("com.lym")
@EnableDubboConfiguration
@EnableDiscoveryClient
@EnableDubbo
public class ControllerBoot {

    public static void main(String[] args) {
        SpringApplication.run(ControllerBoot.class,args);
        System.out.println("|----------Start Controller---------|");
    }
}
