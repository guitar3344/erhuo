package com.jita.erhuo.controller;

import com.jita.erhuo.entity.User;
import com.jita.erhuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "home.do",method = RequestMethod.GET)
    public String hello(ModelMap model) {
        User user = userService.findUserById(1L);
        model.addAttribute("message", user.getNickname());
        return "home";
    }
}