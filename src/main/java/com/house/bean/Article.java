package com.house.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
    private Long id;
    private Long userId;
    private Date createTime;
    private String title;
    private String address;
    private String tel;
    private String type;
    private Boolean isDel;
    private Boolean isBan;
    private String context;
    private Boolean articleType;
}
