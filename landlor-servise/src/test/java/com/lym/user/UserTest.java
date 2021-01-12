package com.lym.user;

import com.lym.ServiceBoot;
import com.lym.dubbo.DubboUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author LYM
 * @Description 用户测试
 * @Date 2021/1/2
 * @Version v1.0.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceBoot.class)
@EnableAutoConfiguration()
public class UserTest {

    @Autowired
    private DubboUser dubboUser;

    @Test
    public void test(){
      //  dubboUser.saveUser();
    };
}
