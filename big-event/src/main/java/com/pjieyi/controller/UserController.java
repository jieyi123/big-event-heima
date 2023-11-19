package com.pjieyi.controller;


import com.pjieyi.pojo.Result;
import com.pjieyi.pojo.User;
import com.pjieyi.service.UserService;
import com.pjieyi.utils.JwtUtil;
import com.pjieyi.utils.Md5Util;
import com.pjieyi.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author pjieyi
 * @Description 用户相关接口
 */
@RequestMapping("/user")
@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password){
        //  /S{5,16}正则表达式 匹配不为空的5-16个字符
        User user = userService.findByUsername(username);
        if (user == null){
            //用户不存在 新增
            userService.addUser(username,password);
            return Result.success();
        }else {
            return Result.error("用户名已存在");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}") String username, @Pattern(regexp = "^\\S{5,16}") String password){
        //根据用户名查询用户
        User user = userService.findByUsername(username);
        if (user ==null ){
            //用户名不存在
            return Result.error("用户名错误");
        }
        //用户名存在
        if (Md5Util.getMD5String(password).equals(user.getPassword())) {
            //密码正确 返回jwt令牌
            Map<String,Object> map=new HashMap<>();
            map.put("username",user.getUsername());
            map.put("id",user.getId());
            String token = JwtUtil.genToken(map);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }


    //获取用户详细信息
    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        Map<String, Object> userMap = ThreadLocalUtil.get();
        String username=(String)(userMap.get("username"));
        User userInfo = userService.findByUsername(username);
        return Result.success(userInfo);
    }

    //更新用户信息
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.updateUser(user);
        return Result.success();
    }

    //修改头像
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){ //@URL保证是一个合法的URL地址
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    //更新用户密码
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        String oldPwd=params.get("old_pwd");
        String newPwd=params.get("new_pwd");
        String rePwd=params.get("re_pwd");
        //校验参数
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd)|| !StringUtils.hasLength(rePwd)){
            return Result.error("参数不合法");
        }
        if (!newPwd.equals(rePwd)){
            return Result.error("两次密码不正确");
        }
        if (newPwd.length()<5||rePwd.length()<5){
            return Result.error("密码最少5位数以上");
        }
        User user=userService.findByUsername(ThreadLocalUtil.getUsername());
        if (!user.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码不正确");
        }
        userService.updatePwd(rePwd);
        return Result.success();
    }
}
