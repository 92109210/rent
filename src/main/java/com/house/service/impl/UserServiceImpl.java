package com.house.service.impl;

import com.house.bean.User;
import com.house.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements com.house.service.UserService {
    @Autowired
    UserMapper userMapper;

    //应该屏蔽其他字段
    @Override
    public User checkUser(User user) {
        List<User> list = userMapper.select(user);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    //添加用户
    @Override
    public Boolean add(User user) {
        user.setCreateTime(new java.sql.Date(new Date().getTime()));
        user.setRecentLoginTime(new java.sql.Date(new Date().getTime()));
        Integer rs = userMapper.add(user);
        if (rs == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean changeUserInfo(Long id, User user) {
        User user1 = new User();
        user1.setId(id);
        user.setAccount(null);
        Integer rs = userMapper.update(user1, user);
        if (rs == 1) {
            return true;
        }
        return false;
    }
}
