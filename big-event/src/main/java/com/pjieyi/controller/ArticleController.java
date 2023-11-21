package com.pjieyi.controller;

import com.pjieyi.pojo.Article;
import com.pjieyi.pojo.PageBean;
import com.pjieyi.pojo.Result;
import com.pjieyi.service.ArticleService;
import com.pjieyi.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author pjieyi
 * @Description
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum,Integer pageSize,
                                          @RequestParam(required = false) Integer categoryId,
                                          @RequestParam(required = false) String state){
        PageBean<Article> articleList=articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(articleList);
    }

    @PostMapping
    public Result addArticle(@RequestBody @Validated Article article){
        articleService.addArticle(article);
        return Result.success();
    }
}
