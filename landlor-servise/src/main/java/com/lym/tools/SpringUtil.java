package com.lym.tools;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author LYM
 * @Description 自定义获取bean
 * @Date 2021/2/22
 * @Version v1.0.0
 **/
@Component
public class SpringUtil implements ApplicationContextAware {


    /**
     * 当前IOC
     *
     */
    private static ApplicationContext applicationContext;
    /**
     * 设置applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 从当前IOC获取bean
     */
    public static <T> T getObject(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    public static void showClass(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            System.out.println(beanDefinitionName);
        }
    }

}
