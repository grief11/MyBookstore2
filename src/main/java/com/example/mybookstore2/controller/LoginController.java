package com.example.mybookstore2.controller;


import com.example.mybookstore2.entity.User;
import com.example.mybookstore2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping({"login", "/"})
    public String login() {
        return "login";
    }

    @PostMapping("tologin")
    public String tologin(User user, Model model, HttpSession session) {
       User user1 = userService.queryUser(user);
       if (user1 != null){
           session.setAttribute("user",user1);
           return "redirect:/index";
       }
       model.addAttribute("msg","用户不存在·");
       return "login";
    }
    @GetMapping("index")
    public String toindex() {
        return "index";
    }

    @GetMapping("/noauth")
    public String noauth() {
        return "noauth";
    }

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
