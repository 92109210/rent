package com.house.service;

public interface LikeService {
    //通过id获取文章点赞数
    Long selectArticleNum(Long id);

    //为文章点赞
    Boolean toLike(Long userId,Long articleId);

    //取消文章的赞
    Boolean cancleLike(Long userId,Long articleId);

    //查询点赞状态
    Boolean likeStatus(Long userId,Long articleId);
}
