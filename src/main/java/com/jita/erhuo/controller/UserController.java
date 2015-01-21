package com.jita.erhuo.controller;

import com.jita.erhuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by guitar on 15/1/20.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "login.do",method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }
}
