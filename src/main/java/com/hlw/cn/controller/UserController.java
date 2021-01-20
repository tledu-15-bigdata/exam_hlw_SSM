package com.hlw.cn.controller;

import com.hlw.cn.pojo.User;
import com.hlw.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //验证账号
    @RequestMapping("/volidateAcc")
    @ResponseBody
    public Boolean volidateAcc(String acc){

        return userService.validateAcc(acc);
    }

    //验证手机号
    @RequestMapping("/volidatePhone")
    @ResponseBody
    public Boolean volidatePhine(String phone){

        return userService.validatePhone(phone);
    }

    //注册用户
    @RequestMapping("/registerUser")
    @ResponseBody
    public Boolean registerUser(@RequestBody User user){

        return userService.registerUser(user);
    }

    //用户登录
    @RequestMapping("/validateUser")
    @ResponseBody
    public User validateUser(@RequestBody User user){

        System.out.println(user);

        return userService.validateUser(new User(UUID.randomUUID().toString(),user.getUserName(),user.getUserAcc(),user.getUserPwd(),user.getUserEmail(),user.getUserPhone()));
    }
}
