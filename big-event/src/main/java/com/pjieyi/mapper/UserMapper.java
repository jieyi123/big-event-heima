package com.pjieyi.mapper;

import com.pjieyi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author pjieyi
 * @Description
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where username= #{username}")
    public User findByUsername(String username);

    @Insert("insert into user(username,password,create_time,update_time) " +
            "values (#{username},#{password},now(),now())")
    public void addUser(String username, String password);
}
