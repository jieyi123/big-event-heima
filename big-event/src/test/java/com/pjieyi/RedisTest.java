package com.pjieyi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @Author pjieyi
 * @Description
 */
@SpringBootTest  //如果在测试类加上了这个注解，那么将来单元测试方法执行前，会先初始化Spring容器
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testSet(){
        ValueOperations<String, String> ope = redisTemplate.opsForValue();
        //ope.set("username","张三");
        ope.set("password","123",120, TimeUnit.SECONDS);
    }

    @Test
    public void testGet(){
        ValueOperations<String, String> ope = redisTemplate.opsForValue();
        ope.get("username");
    }
}
