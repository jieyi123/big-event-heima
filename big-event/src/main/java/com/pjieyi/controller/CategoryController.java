package com.pjieyi.controller;

import com.pjieyi.pojo.Category;
import com.pjieyi.pojo.Result;
import com.pjieyi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author pjieyi
 * @Description 文章分类相关
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody @Validated Category category){
        categoryService.addCategory(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> selectCategory(){
        List<Category> list = categoryService.selectCategory();
        return Result.success(list);
    }

    @GetMapping("/detail")
    public Result<Category> detail(@RequestParam Integer id){
        Category category=categoryService.findById(id);
        return Result.success(category);
    }

}
