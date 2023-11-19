package com.pjieyi.controller;

import com.pjieyi.pojo.Result;
import com.pjieyi.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author pjieyi
 * @Description
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result list(){
        return Result.success("所有文章数据。。。");
    }
}
