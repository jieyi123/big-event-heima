package com.pjieyi;

import org.junit.jupiter.api.Test;

/**
 * @Author pjieyi
 * @Description 测试ThreadLocal是否线程安全
 */
public class ThreadLocalTest {

    @Test
    public void test(){
        //提供一个ThreadLocal对象
        ThreadLocal tl=new ThreadLocal();
        //开启两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set("张三");
                System.out.println(tl.get());
                System.out.println(tl.get());
                System.out.println(tl.get());
            }
        }).start();

        new Thread(() -> {
            tl.set("李四");
            System.out.println(tl.get());
            System.out.println(tl.get());
            System.out.println(tl.get());
        }).start();
    }
}
