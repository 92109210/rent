package com.house.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminBan {
    private Long id;
    private String adminId;
    private Date startTime;
    private Date endTime;
    private String note;
}
