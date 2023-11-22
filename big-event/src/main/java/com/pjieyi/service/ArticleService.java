package com.pjieyi.service;

import com.pjieyi.pojo.Article;
import com.pjieyi.pojo.PageBean;
import com.pjieyi.pojo.Result;

/**
 * @Author pjieyi
 * @Description
 */
public interface ArticleService {

    //新增文章
    public void addArticle(Article article);

    //分页查询文章
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    //根据id查询文章
    Article findById(Integer id);

    //更新文章
    void update(Article article);

    //删除文章
    void delete(Integer id);
}
