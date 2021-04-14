package com.house.dao;

import com.house.bean.AdminBan;
import com.house.bean.AdminBan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminBanMapper {

    //添加AdminBan
    Integer add(AdminBan adminBan);

    //删除AdminBan
    Integer delete(AdminBan adminBan);

    //更新AdminBan
    Integer update(@Param("old") AdminBan old,@Param("now") AdminBan now);

    //查询AdminBan
    List<AdminBan> select(AdminBan adminBan);

}
