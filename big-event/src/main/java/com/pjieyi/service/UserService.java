package com.pjieyi.service;

import com.pjieyi.pojo.User;

/**
 * @Author pjieyi
 * @Description
 */
public interface UserService {

    public User findByUsername(String username);
    public void addUser(String username,String password);

    //更新用户信息
    void updateUser(User user);

    //更新头像
    void updateAvatar(String avatarUrl);
}
