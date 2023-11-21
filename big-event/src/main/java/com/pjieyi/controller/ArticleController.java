package com.pjieyi.controller;

import com.pjieyi.pojo.Article;
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

    @GetMapping("/list")
    public Result list(){
        return Result.success("所有文章数据。。。");
    }

    @PostMapping
    public Result addArticle(@RequestBody @Validated Article article){
        articleService.addArticle(article);
        return Result.success();
    }
}
