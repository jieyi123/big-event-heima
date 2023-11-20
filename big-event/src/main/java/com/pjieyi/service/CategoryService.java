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
}