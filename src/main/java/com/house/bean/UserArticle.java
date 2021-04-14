package com.house.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserArticle {
    private Long id;
    private Date createTime;
    private String title;
    private String name;
    private Long tel;
}
