package com.house.dao;

import com.house.bean.User;
import com.house.bean.UserArticle;

import java.util.List;

public interface OrderMapper {

    //信息预约数
    Long getArticleOrderNum(Long articleId);

    //获取文章预约人
    List<User> getArticleOrderUser(Long articleId);

    //预约
    Boolean toOrder(Long userId, Long articleId);

    //取消预约
    Boolean cancleOrder(Long userId, Long articleId);

    Integer OrderStatus(Long userId, Long articleId);

    //预约我的
    List<UserArticle> getUserArticle(Long userId, Boolean type);

}
