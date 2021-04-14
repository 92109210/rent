package com.house.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private Long id;
    private String account;
    private String password;
    private Boolean isDel;
    private Boolean isBan;
    private String name;
    private Date createTime;

}
