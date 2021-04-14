package com.house.service;

import com.house.bean.User;

public interface UserService {
    //应该屏蔽其他字段
    User checkUser(User user);

    //添加用户
    Boolean add(User user);

    //根据修改用户信息
    Boolean changeUserInfo(Long id, User user);

}
