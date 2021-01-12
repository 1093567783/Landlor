package com.lym.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author LYM
 * @Description 自定义异常
 * @Date 2021/1/10
 * @Version v1.0.0
 **/
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {
    @ExceptionHandler
    public String ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return "my_error";
    }
}
