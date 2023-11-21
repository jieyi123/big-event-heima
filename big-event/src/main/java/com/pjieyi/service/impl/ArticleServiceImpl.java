package com.pjieyi.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjieyi.mapper.ArticleMapper;
import com.pjieyi.pojo.Article;
import com.pjieyi.pojo.PageBean;
import com.pjieyi.pojo.Result;
import com.pjieyi.service.ArticleService;
import com.pjieyi.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageBean<Article> pb=new PageBean<>();
        //开启分页查询
        PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleMapper.list(ThreadLocalUtil.getUserId(), categoryId, state);
        //Page<Article> page=(Page<Article>)list;
        //pb.setTotal(page.getTotal());
        //pb.setItems(page.getResult());
        PageInfo<Article> info=new PageInfo<>(list);
        pb.setTotal(info.getTotal());
        pb.setItems(info.getList());
        return pb;
    }

    @Override
    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    @Override
    public void update(Article article) {
        article.setCreateUser(ThreadLocalUtil.getUserId());
        articleMapper.update(article);
    }
}
