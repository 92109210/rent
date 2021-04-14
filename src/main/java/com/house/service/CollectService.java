package com.house.service;

import com.github.pagehelper.PageInfo;
import com.house.bean.ArticleLO;

import java.util.List;

public interface CollectService {

    //收藏
    Boolean create(Long userId, Long articleId);

    //判断收藏是否存在
    Boolean isExit(Long userId, Long articleId);

    //取消收藏
    Boolean delete(Long userId, Long articleId);

    //查询用户收藏,类型，false为出租，true为求租
    PageInfo<ArticleLO> select(int curr, int limit, Long userId);

//    List<ArticleLO> select(Long userId);
}
