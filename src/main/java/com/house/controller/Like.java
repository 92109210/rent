package com.house.controller;

import com.house.bean.Result;
import com.house.bean.User;
import com.house.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;

@Controller
public class Like {

    @Autowired
    LikeService likeService;

    //查询文章点赞数量
    @ResponseBody
    @GetMapping("/Like/{articleId}")
    public String getNum(@PathVariable("id") Long id) {
        Long rs = likeService.selectArticleNum(id);
        return rs.toString();
    }

    //为文章点赞
    @ResponseBody
    @PostMapping("/Like/{articleId}")
    public String toLike(@PathVariable("articleId") Long articleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        Boolean rs = likeService.toLike(id, articleId);
        return rs.toString();
    }

    //取消点赞
    @ResponseBody
    @DeleteMapping("/Like/{articleId}")
    public String cancelLike(@PathVariable("articleId") Long articleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        Boolean rs = likeService.cancleLike(id, articleId);
        return rs.toString();
    }

    //查询用户点赞状态
    @ResponseBody
    @GetMapping("/LikeStatus/{articleId}")
    public Result likeStatus(@PathVariable("articleId") Long articleId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Result.fail();
        }
        Long id = user.getId();
        Boolean rs = likeService.likeStatus(id, articleId);
        if (rs) {
            return Result.success();
        }
        return Result.fail();
    }
}
