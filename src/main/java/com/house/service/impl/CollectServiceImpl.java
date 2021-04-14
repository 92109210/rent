package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.bean.ArticleLO;
import com.house.dao.CollectMapper;
import com.house.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    @Override
    public Boolean create(Long userId, Long articleId) {
        if (isExit(userId, articleId)) {
            return false;
        }
        return collectMapper.create(userId, articleId);
    }

    @Override
    public Boolean isExit(Long userId, Long articleId) {
        return collectMapper.isExit(userId, articleId);
    }

    @Override
    public Boolean delete(Long userId, Long articleId) {
        return collectMapper.delete(userId, articleId);
    }

    @Override
    public PageInfo<ArticleLO> select(int curr, int limit, Long userId) {
        PageHelper.startPage(curr, limit);
        List<ArticleLO> list = collectMapper.select(userId);
        PageInfo<ArticleLO> pageInfo = new PageInfo<ArticleLO>(list);
        return pageInfo;
    }
}
