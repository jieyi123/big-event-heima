package com.pjieyi.service;

import com.pjieyi.pojo.Category;

import java.util.List;

/**
 * @Author pjieyi
 * @Description
 */
public interface CategoryService {


    /**
     * 新增文章分类
     */
    public void addCategory(Category category);

    //查询文章分类
    List<Category> selectCategory();

    //根据文章id查询分类信息
    Category findById(Integer id);

    //更新文章分类
    void update(Category category);
}
