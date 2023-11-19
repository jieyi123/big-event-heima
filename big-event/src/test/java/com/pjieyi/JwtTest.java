package com.pjieyi;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author pjieyi
 * @Description jwt测试
 */
public class JwtTest {


    @Test
    public void testToken(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        //生成jwt
        String token=JWT.create()
                .withClaim("user",claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60))//添加过期时间
                .sign(Algorithm.HMAC256("pjieyi")); //指定算法 配置加密密钥
        System.out.println(token);
    }

    //解密
    @Test
    public void testParse(){
        //定义字符串模拟用户传递过来的token
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDAzNzE3NzQsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19.TlJ8NaR6ia6C2eiQYoEJ-6v2TZYFYka1OwOGdlIEtH0";
        //生成JWT验证器
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("pjieyi")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token 生成一个解析后的JWT对象
        //Map<String, Claim> claims = decodedJWT.getClaims();
        //System.out.println(claims.get("user"));
        Map<String, Object> map = decodedJWT.getClaim("user").asMap(); //如果token错误就会出现异常
        System.out.println(map.get("username"));//张三
    }
    //如果篡改了头部和载荷部分的数据，那么验证失败
    //如果密钥改了，验证失败
    //token过期 验证失败
}
