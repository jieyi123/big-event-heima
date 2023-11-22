package com.pjieyi.mapper;

import com.pjieyi.pojo.Article;
import com.pjieyi.pojo.PageBean;
import com.pjieyi.pojo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author pjieyi
 * @Description  文章相关
 */
@Mapper
public interface ArticleMapper {


    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time)" +
            "" +
            " values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},now(),now())")
    public void addArticle(Article article);

    List<Article> list(Integer createUser, Integer categoryId, String state);

    @Select("select * from article where id=#{id}")
    Article findById(Integer id);

    @Update("update article set title=#{title},cover_img=#{coverImg},content=#{content},state=#{state},category_id=#{categoryId},update_time=now() " +
            " where id=#{id} ")
    void update(Article article);

    @Delete("delete from article where id=#{id}")
    void delete(Integer id);
}
