package com.house.dao;

import com.house.bean.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    //添加Admin
    Integer add(Admin admin);

    //删除Admin
    Integer delete(Admin admin);

    //更新Admin
    Integer update(@Param("old") Admin old,@Param("now") Admin now);

    //查询Admin
    List<Admin> select(Admin admin);

}
