package com.house.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;
    private String msg;
    private HashMap<String, Object> data = new HashMap<String, Object>();

    public static Result success() {
        Result result = new Result();
        result.code = 200;
        result.msg = "成功";
        return result;
    }

    public static Result success(String msg) {
        Result result = success();
        result.msg = msg;
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.code = 400;
        result.msg = "失败";
        return result;
    }

    public static Result fail(String msg) {
        Result result = fail();
        result.msg = msg;
        return result;
    }

    public void put(String key, Object object) {
        this.data.put(key, object);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
