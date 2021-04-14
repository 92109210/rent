package com.house.service;

import com.github.pagehelper.PageInfo;
import com.house.bean.Article;
import com.house.bean.ArticleLO;

public interface ArticleService {

    //创建出租文章
    Boolean createOut(Article article);

    //创建求租文章
    Boolean createNeed(Article article);

    //获得出租列表，分页
    PageInfo<ArticleLO> getOut(int curr, int limit);

    //获得求租列表，分页
    PageInfo<ArticleLO> getNeed(int curr, int limit);

    //用id搜索
    ArticleLO selectById(Long id);

    //通过用户id查询出租信息
    PageInfo<ArticleLO> selectOutByUserId(Long id, int curr, int limit);

    //通过用户id查询求租信息
    PageInfo<ArticleLO> selectNeedByUserId(Long id, int curr, int limit);
}
