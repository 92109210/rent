package com.house.dao;

import com.house.bean.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleNeedMapper {

    //添加Article
    Integer add(Article article);

    //删除Article
    Integer delete(Article article);

    //更新Article
    Integer update(@Param("old") Article old, @Param("now") Article now);

    //查询Article
    List<Article> select(Article article);

}
