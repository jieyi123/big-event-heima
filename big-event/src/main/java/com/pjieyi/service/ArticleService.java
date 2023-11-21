package com.pjieyi.service;

import com.pjieyi.pojo.Article;
import com.pjieyi.pojo.PageBean;

/**
 * @Author pjieyi
 * @Description
 */
public interface ArticleService {

    //新增文章
    public void addArticle(Article article);

    //分页查询文章
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
