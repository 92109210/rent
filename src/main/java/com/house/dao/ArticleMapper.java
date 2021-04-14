package com.house.dao;

import com.house.bean.Article;
import com.house.bean.ArticleLO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {

    //添加Article
    Integer add(Article article);

    //删除Article
    Integer delete(Article article);

    //更新Article
    Integer update(@Param("old") Article old, @Param("now") Article now);

    //查询Article
    List<Article> select(Article article);

    //获得所有出租信息
    List<ArticleLO> getAll(Boolean articleType);

    //通过文章id查询
    List<ArticleLO> selectById(Long id);

    //查询ArticleLO
    List<ArticleLO> selectArticleLO(ArticleLO articleLO);

}
