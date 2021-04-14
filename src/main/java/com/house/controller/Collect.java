package com.house.controller;


import com.github.pagehelper.PageInfo;
import com.house.bean.ArticleLO;
import com.house.bean.Result;
import com.house.bean.User;
import com.house.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Collect {

    @Autowired
    CollectService collectService;


    //收藏文章
    @ResponseBody
    @PostMapping("/Collect/{articleId}")
    public String toCollect(@PathVariable("articleId") Long articleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        Boolean rs = collectService.create(id, articleId);
        return rs.toString();
    }

    //取消收藏
    @ResponseBody
    @DeleteMapping("/Collect/{articleId}")
    public String cancelCollect(@PathVariable("articleId") Long articleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        Boolean rs = collectService.delete(id, articleId);
        return rs.toString();
    }

    //查询用户收藏状态
    @ResponseBody
    @GetMapping("/Collect/{articleId}")
    public Result collectStatus(@PathVariable("articleId") Long articleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail();
        }
        Long id = user.getId();
        Boolean rs = collectService.isExit(id, articleId);
        if (rs) {
            return Result.success();
        }
        return Result.fail();

    }

    //查询我的收藏
    @ResponseBody
    @GetMapping("/myCollection")
    public Result myCollect(int curr, int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail();
        }
        Long id = user.getId();
        PageInfo<ArticleLO> list = collectService.select(curr, limit, id);
        Result result = Result.success();
        result.put("pageInfo", list);
        return result;
    }

}
