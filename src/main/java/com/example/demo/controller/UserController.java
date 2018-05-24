package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lixingyuan on 2018/5/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/toLogin")
    public  String toLogin(){
        return "login";
    }

   /* @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(String username,String password){
        User user = userService.findByUsernameAanPassword(username,password);
        if (user!=null) {
            return "/s/success";
        }
        return "login";

    }*/
    @RequestMapping(value="/findByPassword",method = RequestMethod.GET)
    public String findByUserName(String password){
        LOGGER.info("findByPassword--",password);
        System.out.println("----------"+password);
       User user = userService.findByPassword(password);
        System.out.println(user.getUsername());
        return "/s/success";
    }
}
