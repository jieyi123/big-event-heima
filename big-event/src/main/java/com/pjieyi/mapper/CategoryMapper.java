package com.pjieyi.mapper;

import com.pjieyi.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author pjieyi
 * @Description
 */
@Mapper
public interface CategoryMapper {
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) values(#{categoryName},#{categoryAlias},#{id},now(),now()) ")
    public void addCategory(Category category);
}
