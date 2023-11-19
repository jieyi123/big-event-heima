package com.pjieyi.utils;

import java.util.Map;

/**
 * @Author pjieyi
 * @Description
 */
public class ThreadLocalUtil {

    //创建全局对象
    public static final ThreadLocal THREAD_LOCAL=new ThreadLocal();

    //根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }

    //存储键值对
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }

    //清除ThreadLocal防止内存泄露
    public static void remove(){
        THREAD_LOCAL.remove();
    }

    public static Integer getUserId(){
        Map<String,Object> userMap=ThreadLocalUtil.get();
        return (Integer) userMap.get("id");
    }

    public static String getUsername(){
        Map<String,Object> userMap=ThreadLocalUtil.get();
        return (String) userMap.get("username");
    }
}
