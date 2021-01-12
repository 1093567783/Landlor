package com.lym.model.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LYM
 * @Description 返回的结果
 * @Date 2021/1/12
 * @Version v1.0.0
 **/
@Data
public class Result <T> implements Serializable {
    private String code;
    private String msg;
    private T data;

     public Result() {
        this.code = UnifyStrErrorCode.SUCCESS.SUCCESS_CODE;
        this.msg = UnifyStrErrorCode.SUCCESS.SUCCESS_MSG;
    }

    private Result(T data) {
        this.code = UnifyStrErrorCode.SUCCESS.SUCCESS_CODE;
        this.msg = UnifyStrErrorCode.SUCCESS.SUCCESS_MSG;
        this.setData(data);
    }

    private Result(String code, String msg) {
        this.code = UnifyStrErrorCode.SUCCESS.SUCCESS_CODE;
        this.msg = UnifyStrErrorCode.SUCCESS.SUCCESS_MSG;
        this.setCode(code);
        this.setMsg(msg);
    }

    private Result(String code, String msg, T data) {
        this.code = UnifyStrErrorCode.SUCCESS.SUCCESS_CODE;
        this.msg = UnifyStrErrorCode.SUCCESS.SUCCESS_MSG;
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public Result<T> setError(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }


    public static Result instance() {
        return new Result();
    }

    public static <T> Result instance(T data) {
        return new Result(data);
    }

    public static <T> Result instance(String code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result instance(String code, String msg, T data) {
        return new Result(code, msg, data);
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> toJsonMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", this.data);
        map.put("msg", this.msg);
        map.put("code", this.code);
        return map;
    }

}
