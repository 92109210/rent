package com.house.service;

import com.house.bean.User;
import com.house.bean.UserArticle;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface OrderService {

    //信息预约数
    Long getArticleOrderNum(Long articleId);

    //获取文章预约人
    List<User> getArticleOrderUser(Long articleId);

    //预约
    Boolean toOrder(Long userId, Long articleId);

    //取消预约
    Boolean cancleOrder(Long userId, Long articleId);

    //查询用户预约状态
    Boolean orderStatus(Long userId, Long articleId);

    List<UserArticle> getUserArticle(Long userId, Boolean type);

}
