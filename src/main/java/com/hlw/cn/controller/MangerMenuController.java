package com.hlw.cn.controller;

import com.hlw.cn.pojo.MangerMenu;
import com.hlw.cn.service.MangerMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *负责人：代朋
 */

@Controller
public class MangerMenuController {

    @Autowired
    private MangerMenuService mangerMenuService;

    @RequestMapping("/queryMenu")
    @ResponseBody
    //菜单栏查询
    //菜单栏原返回值为mangermenu   后修改为list   原因：需要渲染的菜单栏不止一个
    public List<MangerMenu> queryMenu(){
            return mangerMenuService.queryMenuService();
    }
}
