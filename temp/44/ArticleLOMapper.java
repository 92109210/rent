package com.house.dao;

import com.house.bean.ArticleLO;

import java.util.List;

public interface ArticleLOMapper {

    //获得所有出租信息
    List<ArticleLO> getOut();

    //获得所有求租信息
    List<ArticleLO> getNeed();
}
