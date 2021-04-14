package com.house.controller;

import com.github.pagehelper.PageInfo;
import com.house.bean.Article;
import com.house.bean.ArticleLO;
import com.house.bean.Result;
import com.house.bean.User;
import com.house.service.ArticleService;
import com.house.service.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;


//处理出租信息发布
@Controller
public class RentOut {

    @Autowired
    ArticleService articleService;

    //创建出租信息
    @ResponseBody
    @PostMapping("/createO")
    public Result createArticle(Article article, HttpSession session) {
        User user = (User) session.getAttribute("user"); //获得userid 测试状态注释
        if (user == null) {
            return Result.fail("请先登录...");
        }
        article.setUserId(user.getId());
        System.out.println(article.toString());
        Boolean rs = articleService.createOut(article);
        if (!rs) {
            return Result.fail("添加失败...");
        }
        return Result.success("发布成功，等待管理员审核中...");
    }

    //上传文章图片
    @ResponseBody
    @PostMapping(value = "/article/fileupload")
    public Result fileUpload(@RequestParam(value = "file") MultipartFile file) {
        Result result = FileUpload.upload(file);
        return result;
    }

    //查询出租文章信息
    @ResponseBody
    @GetMapping("/rentO")
    public Result getArticle(Integer curr, Integer limit) {
        PageInfo<ArticleLO> list = articleService.getOut(curr, limit);
        Result rs = Result.success("成功");
        if (list != null) {
            rs.put("pageInfo", list);
        }
        return rs;
    }

    //根据id查询出租信息
    @GetMapping("/someArticle/{id}")
    public String getSomeArticle(Model model, @PathVariable("id") Long id) {
        ArticleLO article = articleService.selectById(id);
        model.addAttribute("article", article);
        return "showArticle";
    }

    //获取我发布的出租信息
    @ResponseBody
    @GetMapping("/getmypostO")
    public Result getmypostO(HttpSession session, int curr, int limit) {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        PageInfo<ArticleLO> list = articleService.selectOutByUserId(id, curr, limit);
        Result rs = Result.success("成功");
        if (list != null) {
            rs.put("pageInfo", list);
        }
        return rs;
    }


}
