package com.pjieyi.service.impl;

import com.pjieyi.mapper.CategoryMapper;
import com.pjieyi.pojo.Category;
import com.pjieyi.service.CategoryService;
import com.pjieyi.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author pjieyi
 * @Description
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void addCategory(Category category) {
        category.setId(ThreadLocalUtil.getUserId());
        categoryMapper.addCategory(category);
    }
}
