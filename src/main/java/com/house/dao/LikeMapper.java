package com.house.dao;

public interface LikeMapper {

    Long selectByArticleId(Long id);

    Boolean isExist(Long userId, Long articleId);

    Integer add(Long userId, Long articleId);

    Boolean delete(Long userId, Long articleId);

    Integer likeStatus(Long userId, Long articleId);
}
