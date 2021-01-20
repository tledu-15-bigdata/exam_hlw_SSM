package com.hlw.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/volidateAcc")
    @ResponseBody
    public Boolean volidateAcc(String acc){

        return true;
    }
}
