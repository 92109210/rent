package com.house.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;
import javax.websocket.server.PathParam;

@Controller
public class Page {

    @GetMapping("/page/{pageName}")
    public String toPage(@PathVariable String pageName) {
        return pageName;
    }

    @GetMapping("/rentalInNeed")
    public String rentalInNeed(Model model) {
        model.addAttribute("url", "/rentN");
        model.addAttribute("href", "/someNeed");
        return "list";
    }

    @GetMapping("/rentOut")
    public String rentOut(Model model) {
        model.addAttribute("url", "/rentO");
        model.addAttribute("href", "/someArticle");
        return "list";
    }

    //创建出租信息
    @GetMapping("/createO")
    public String createO(Model model) {
        model.addAttribute("url", "/createO");
        return "newArticle";
    }

    //创建求租信息
    @GetMapping("/createN")
    public String createN(Model model) {
        model.addAttribute("url", "/createN");
        return "newArticle";
    }

    //查看我发布的求租信息
    @GetMapping("/mypostN")
    public String mypostN(Model model) {
        model.addAttribute("url", "/getmypostN");
        return "list";
    }

    //查看我发布的出租信息
    @GetMapping("/mypostO")
    public String mypostO(Model model) {
        model.addAttribute("url", "/getmypostO");
        return "list";
    }

    //查看我的收藏
    @GetMapping("/myCollect")
    public String myCollect(Model model) {
        model.addAttribute("url", "/myCollection");
        return "list";
    }

    //查看我的出租预约   别人预约我的信息
    @GetMapping("/myOut")
    public String myOut(Model model) {
        model.addAttribute("url", "/myYYOut");
        return "yylist";
    }

    //查看我的求租预约   别人预约我的信息
    @GetMapping("/myNeed")
    public String myNeed(Model model) {
        model.addAttribute("url", "/myYYNeed");
        return "yylist";
    }

    //查看我的求租预约   别人预约我的信息
    @GetMapping("/change")
    public String change(Model model) {
//        model.addAttribute("url", "/myYYNeed");
        return "change";
    }


}
