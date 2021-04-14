package com.house.controller;


import com.github.pagehelper.PageInfo;
import com.house.bean.Article;
import com.house.bean.ArticleLO;
import com.house.bean.Result;
import com.house.bean.User;
import com.house.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

//处理求租信息
@Controller
public class RentalInNeed {

    @Autowired
    ArticleService articleService;

//    //根据id获取求租信息
//    @GetMapping("/someNeed/{id}")
//    public String someNeed(@PathVariable("id") Long id, Model model) {
//        ArticleLO article = articleService.selectById(id);
//        System.out.println(article);
//        model.addAttribute("article", article);
//        System.out.println(article);
//        return "showArticle";
//    }

    //创建求租信息
    @ResponseBody
    @PostMapping("/createN")
    public Result createNeedArticle(Article article, HttpSession session) {
        User user = (User) session.getAttribute("user"); //获得userid 测试状态注释
        if (user == null) {
            return Result.fail("请先登录...");
        }
        article.setUserId(user.getId());
        System.out.println(article.toString());
        Boolean rs = articleService.createNeed(article);
        if (!rs) {
            return Result.fail("添加失败...");
        }
        return Result.success("发布成功，等待管理员审核中...");
    }

    //获取所有求租信息
    @ResponseBody
    @GetMapping("/rentN")
    public Result getNeedArticle(int curr, int limit) {
        System.out.println(curr);
        System.out.println(limit);
        PageInfo<ArticleLO> list = articleService.getNeed(curr, limit);
        Result rs = Result.success("成功");
        if (list != null) {
            rs.put("pageInfo", list);
        }
        return rs;
    }

    //获取我发布的求租信息
    @ResponseBody
    @GetMapping("/getmypostN")
    public Result getmypostN(HttpSession session, int curr, int limit) {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        PageInfo<ArticleLO> list = articleService.selectNeedByUserId(id, curr, limit);
        Result rs = Result.success("成功");
        if (list != null) {
            rs.put("pageInfo", list);
        }
        return rs;
    }


}
