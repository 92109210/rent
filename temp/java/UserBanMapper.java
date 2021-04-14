package com.house.dao;

import com.house.bean.UserBan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBanMapper {

    //添加UserBan
    Integer add(UserBan userBan);

    //删除UserBan
    Integer delete(UserBan userBan);

    //更新UserBan
    Integer update(@Param("old") UserBan old,@Param("now") UserBan now);

    //查询UserBan
    List<UserBan> select(UserBan userBan);

}
