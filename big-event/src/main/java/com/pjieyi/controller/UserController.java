package com.pjieyi.controller;


import com.pjieyi.pojo.Result;
import com.pjieyi.pojo.User;
import com.pjieyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author pjieyi
 * @Description 用户相关接口
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username,String password){
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
