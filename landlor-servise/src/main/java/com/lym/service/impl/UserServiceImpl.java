package com.lym.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.lym.dubbo.DubboUser;
import com.lym.manager.UserManager;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.lym.service.UserService;
import vo.UserVO;

/**
 * @Author LYM
 * @Description 用户服务实现类
 * @Date 2020/12/28
 * @Version v1.0.0
 **/
@Service(interfaceClass = DubboUser.class, delay = -1, retries = 0)
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserManager userManager;

    @Override
    public void saveUser() {
        System.out.println("web成功");
        userManager.saveUser();
    }

    @Override
    public UserVO login(UserDTO userDTO) {
        return userManager.login(userDTO);
    }
}
