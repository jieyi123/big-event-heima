package com.pjieyi.mapper;

import com.pjieyi.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author pjieyi
 * @Description
 */
@Mapper
public interface CategoryMapper {
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) values(#{categoryName},#{categoryAlias},#{id},now(),now()) ")
    public void addCategory(Category category);

    @Select("select * from category where create_user=#{userId} order by update_time desc")
    List<Category> select(Integer userId);

    @Select("select * from category where id=#{id}")
    Category findById(Integer id);

    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=now() where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
