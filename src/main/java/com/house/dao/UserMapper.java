package com.house.dao;

import com.house.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //添加User
    Integer add(User user);

    //删除User
    Integer delete(User user);

    //更新User
    Integer update(@Param("old") User old, @Param("now") User now);

    //查询User
    List<User> select(User user);
}
