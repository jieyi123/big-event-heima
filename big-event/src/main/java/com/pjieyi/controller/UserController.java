package com.pjieyi.controller;


import com.pjieyi.pojo.Result;
import com.pjieyi.pojo.User;
import com.pjieyi.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
