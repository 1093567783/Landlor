package com.lym.model.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author LYM
 * @Description 类型转换工具类
 * @Date 2021/2/7
 * @Version v1.0.0
 **/
public class TypeUtil {
    /**
     * 功能描述: byte数组转 InputStream
     *
     * @param bytes byte数组
     * @return java.io.InputStream
     * @author xiaobu
     * @date 2019/3/28 16:01
     * @version 1.0
     */
    public static InputStream byteInputStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }


    /**
     * InputStream转化为byte[]数组
     * @param input
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}
