package com.house.service.impl;

import com.house.dao.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements com.house.service.LikeService {

    @Autowired
    LikeMapper likeMapper;

    //获取
    @Override
    public Long selectArticleNum(Long id) {
        Long rs = likeMapper.selectByArticleId(id);
        System.out.println(rs);
        return rs;
    }

    @Override
    public Boolean toLike(Long userId, Long articleId) {
        Boolean isExist = likeMapper.isExist(userId, articleId);
        if (isExist == false) {
            Integer rs = likeMapper.add(userId, articleId);
        }
        return true;
    }

    @Override
    public Boolean cancleLike(Long userId, Long articleId) {
        Boolean rm = likeMapper.delete(userId, articleId);
        return true;
    }

    @Override
    public Boolean likeStatus(Long userId, Long articleId) {
        Integer rs = likeMapper.likeStatus(userId, articleId);
        if (rs > 0) {
            return true;
        }
        return false;
    }
}
