package com.pjieyi.mapper;

import com.pjieyi.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
}
