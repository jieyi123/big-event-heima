package com.pjieyi.service.impl;

import com.pjieyi.mapper.UserMapper;
import com.pjieyi.pojo.User;
import com.pjieyi.service.UserService;
import com.pjieyi.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author pjieyi
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //查询用户
    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    //注册用户
    public void addUser(String username, String password){
        //密码进行MD5加密加密
        String md5String = Md5Util.getMD5String(password);
        userMapper.addUser(username,md5String);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
