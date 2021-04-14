package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.bean.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleNeedServiceImpl implements com.house.service.ArticleNeedService {

    @Autowired
    ArticleNeedMapper articleNeedMapper;

    @Override
    public Boolean createArticle(Article article) {
        article.setCreateTime(new java.sql.Date(new Date().getTime()));
        Integer rs = articleNeedMapper.add(article);
        if (rs == 1) {
            return true;
        }
        return false;
    }


    //分页
    @Override
    public PageInfo<Article> getAll(int curr, int limit) {
        PageHelper.startPage(curr, limit);
        List<Article> list = articleNeedMapper.select(null);
        PageInfo<Article> pageInfo = new PageInfo<Article>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    //用id搜索
    @Override
    public Article selectById(Long id) {
        Article article = new Article();
        article.setId(id);
        List<Article> list = articleNeedMapper.select(article);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageInfo<Article> selectByUserId(Long id, int curr, int limit) {
        Article article = new Article();
        article.setUserId(id);
        PageHelper.startPage(curr, limit);
        List<Article> list = articleNeedMapper.select(article);
        PageInfo<Article> pageInfo = new PageInfo<Article>(list);
        return pageInfo;
    }

}
