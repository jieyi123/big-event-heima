package com.pjieyi.service.impl;

import com.pjieyi.mapper.ArticleMapper;
import com.pjieyi.pojo.Article;
import com.pjieyi.service.ArticleService;
import com.pjieyi.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author pjieyi
 * @Description
 */
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void addArticle(Article article) {
        article.setCreateUser(ThreadLocalUtil.getUserId());
        articleMapper.addArticle(article);
    }
}
