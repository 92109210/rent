package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.bean.Article;
import com.house.bean.ArticleLO;
import com.house.dao.ArticleMapper;
import com.house.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    //创建文章
    public Boolean create(Article article) {
        article.setCreateTime(new java.sql.Date(new Date().getTime()));
        Integer rs = articleMapper.add(article);
        if (rs.equals(1)) {
            return true;
        }
        return false;
    }

    //创建出租文章
    @Override
    public Boolean createOut(Article article) {
        article.setArticleType(false);
        return create(article);
    }

    //创建求租文章
    @Override
    public Boolean createNeed(Article article) {
        article.setArticleType(true);
        return create(article);
    }


    @Override
    public PageInfo<ArticleLO> getOut(int curr, int limit) {
        System.out.println(curr);
        System.out.println(limit);
//        使用分页插件,核心代码就这一行
        PageHelper.startPage(curr, limit);
        List<ArticleLO> list = articleMapper.getAll(false);
        PageInfo<ArticleLO> pageInfo = new PageInfo<ArticleLO>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public PageInfo<ArticleLO> getNeed(int curr, int limit) {
        System.out.println(curr);
        System.out.println(limit);
//        使用分页插件,核心代码就这一行
        PageHelper.startPage(curr, limit);
        List<ArticleLO> list = articleMapper.getAll(true);
        PageInfo<ArticleLO> pageInfo = new PageInfo<ArticleLO>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @Override
    public ArticleLO selectById(Long id) {
        ArticleLO article = new ArticleLO();
        article.setId(id);
        List<ArticleLO> list = articleMapper.selectById(id);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PageInfo<ArticleLO> selectOutByUserId(Long id, int curr, int limit) {
        ArticleLO article = new ArticleLO();
        article.setArticleType(false);
        article.setUserId(id);
        PageHelper.startPage(curr, limit);
        List<ArticleLO> list = articleMapper.selectArticleLO(article);
        PageInfo<ArticleLO> pageInfo = new PageInfo<ArticleLO>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ArticleLO> selectNeedByUserId(Long id, int curr, int limit) {
        ArticleLO article = new ArticleLO();
        article.setArticleType(true);
        article.setUserId(id);
        PageHelper.startPage(curr, limit);
        List<ArticleLO> list = articleMapper.selectArticleLO(article);
        PageInfo<ArticleLO> pageInfo = new PageInfo<ArticleLO>(list);
        return pageInfo;
    }


//    //创建出租文章
//    @Override
//    public Boolean createOut(Article article) {
//        article.setCreateTime(new java.sql.Date(new Date().getTime()));
//        article.setArticleType(false);
//        Integer rs = articleMapper.add(article);
//        if (rs.equals(1)) {
//            return true;
//        }
//        return false;
//    }
//
//    //创建求租文章
//    @Override
//    public Boolean createNeed(Article article) {
//        article.setCreateTime(new java.sql.Date(new Date().getTime()));
//        article.setArticleType(true);
//        Integer rs = articleMapper.add(article);
//        if (rs == 1) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public PageInfo<ArticleLO> getOut(int curr, int limit) {
//        return null;
//    }
//
//    @Override
//    public PageInfo<ArticleLO> getNeed(int curr, int limit) {
//        return null;
//    }
//
//
//    //分页
//    @Override
//    public PageInfo<ArticleLO> getAll(int curr, int limit) {
////        System.out.println(curr);
////        System.out.println(limit);
//        //使用分页插件,核心代码就这一行
//        PageHelper.startPage(curr, limit);
//        List<ArticleLO> list = articleLOMapper.getOut();
//        PageInfo<ArticleLO> pageInfo = new PageInfo<ArticleLO>(list);
//        System.out.println(pageInfo);
//        return pageInfo;
//    }
//
//    //用id搜索
//    @Override
//    public Article selectById(Long id) {
//        Article article = new Article();
//        article.setId(id);
//        List<Article> list = articleMapper.select(article);
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
//
//    @Override
//    public PageInfo<Article> selectOutByUserId(Long id, int curr, int limit) {
//        return null;
//    }
//
//    @Override
//    public PageInfo<Article> selectNeedByUserId(Long id, int curr, int limit) {
//        return null;
//    }
//
//    //通过用户id查询出租信息
//    @Override
//    public PageInfo<Article> selectByUserId(Long id, int curr, int limit) {
//        Article article = new Article();
//        article.setUserId(id);
//        PageHelper.startPage(curr, limit);
//        List<Article> list = articleMapper.select(article);
//        PageInfo<Article> pageInfo = new PageInfo<Article>(list);
//        return pageInfo;
//    }
}
