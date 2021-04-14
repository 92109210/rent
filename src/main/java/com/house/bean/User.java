package com.house.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String account;
    private String password;
    private boolean isDel;
    private boolean isBan;
    private Date createTime;
    private Date recentLoginTime;
    private Integer age;
    private String name;
    private String tel;
}
