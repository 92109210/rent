package com.house.controller;

import com.house.bean.Result;
import com.house.bean.User;
import com.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.awt.geom.RectangularShape;
import java.util.Enumeration;

@Controller
public class UserAccount {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        System.out.println("get-login");
        return "sign-in";
    }

    @PostMapping("/login")
    public String check(User user, HttpSession session) {
        System.out.println(user);
        User user1 = userService.checkUser(user);
        if (user1 == null) {
            return "error";
        }
        session.setAttribute("user", user1);
        return "index";
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        Enumeration em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString());
        }
        return "index";
    }

    @ResponseBody
    @PostMapping("/resgister")
    public Result createUser(User user) {
        System.out.println(user);
        Boolean rs = userService.add(user);
        if (rs) {
            return Result.success();
        }
        return Result.fail();
    }

    @GetMapping("/resgister")
    public String resgister() {
        System.out.println("sign-up");
        return "sign-up";
    }

    @ResponseBody
    @PostMapping("/change")
    public Result change(User user, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        System.out.println(user.toString());
        System.out.println(sessionUser.toString());
        if (sessionUser == null) {
            return Result.fail();
        }
        Boolean rs = userService.changeUserInfo(sessionUser.getId(), user);
        System.out.println(rs);
        if (!rs) {
            return Result.fail();
        }
        return Result.success();
    }
}
