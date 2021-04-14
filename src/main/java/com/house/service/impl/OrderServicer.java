package com.house.service.impl;

import com.house.bean.User;
import com.house.bean.UserArticle;
import com.house.dao.OrderMapper;
import com.house.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServicer implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Long getArticleOrderNum(Long articleId) {
        Long rs = orderMapper.getArticleOrderNum(articleId);
        return rs;
    }


    @Override
    public List<User> getArticleOrderUser(Long articleId) {
        return null;
    }

    @Override
    public Boolean toOrder(Long userId, Long articleId) {
        return orderMapper.toOrder(userId, articleId);
    }

    @Override
    public Boolean cancleOrder(Long userId, Long articleId) {
        return orderMapper.cancleOrder(userId, articleId);
    }

    @Override
    public Boolean orderStatus(Long userId, Long articleId) {
        Integer rs = orderMapper.OrderStatus(userId, articleId);
        if (rs > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<UserArticle> getUserArticle(Long userId, Boolean type) {
        return orderMapper.getUserArticle(userId, type);
    }
}
