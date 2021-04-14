package com.house.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.bean.*;
import com.house.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//预约
@Controller
public class Order {

    @Autowired
    OrderService orderServer;

    //获得文章的预约数目
    @ResponseBody
    @GetMapping("/Order/{articleId}")
    public String getOrderNum(@PathVariable("articleId") Long id) {
        return orderServer.getArticleOrderNum(id).toString();
    }

    //文章预约接口
    @ResponseBody
    @PostMapping("/Order/{articleId}")
    public String toOrder(@PathVariable("articleId") Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        return orderServer.toOrder(userId, id).toString();
    }

    //文章取消预约接口
    @ResponseBody
    @DeleteMapping("/Order/{articleId}")
    public String cancelOrder(@PathVariable("articleId") Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long userId = user.getId();
        return orderServer.cancleOrder(userId, id).toString();
    }

    //查询用户预约状态
    @ResponseBody
    @GetMapping("/OrderStatus/{articleId}")
    public Result orderStatus(@PathVariable("articleId") Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail();
        }
        Long userId = user.getId();
        Boolean rs = orderServer.orderStatus(userId, id);
        if (rs) {
            return Result.success();
        }
        return Result.fail();
    }

    //查看我的出租预约   别人预约我的信息
    @ResponseBody
    @GetMapping("/myYYOut")
    public Result myYYOut(int curr, int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail();
        }
        Long userId = user.getId();
        PageHelper.startPage(curr, limit);
        List<UserArticle> list = orderServer.getUserArticle(userId, false);
        PageInfo<UserArticle> pageInfo = new PageInfo<UserArticle>(list);
        Result result = Result.success();
        result.put("pageInfo", pageInfo);
        return result;
    }

    //查看我的求租预约   别人预约我的信息
    @ResponseBody
    @GetMapping("/myYYNeed")
    public Result myYYNeed(int curr, int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail();
        }
        Long userId = user.getId();
        PageHelper.startPage(curr, limit);
        List<UserArticle> list = orderServer.getUserArticle(userId, true);
        PageInfo<UserArticle> pageInfo = new PageInfo<UserArticle>(list);
        Result result = Result.success();
        result.put("pageInfo", pageInfo);
        return result;
    }

}
