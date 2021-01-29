package com.hlw.cn.controller;

import com.hlw.cn.pojo.MangerMenu;
import com.hlw.cn.service.MangerMenuService;
import com.hlw.cn.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    //菜单栏原返回值为mangermenu   后修改为map   原因：需要渲染的菜单栏不止一个
    public Map<String,Object> queryMenu(){
        return mangerMenuService.queryMenuService();
    }

    //查询所有的菜单
    @RequestMapping("/queryMenuAll")
    @ResponseBody
    public PageUtils queryMenuAll(@RequestBody Map<String,Object> map){
            return mangerMenuService.queryMenuAllService(map);
    }

    @RequestMapping("/insertMenu")
    @ResponseBody
    public Boolean insertMenu(@RequestBody MangerMenu mangerMenu){
        return mangerMenuService.insertMenu(mangerMenu);
    }

    //菜单栏修改
    @RequestMapping("/updateMenu")
    @ResponseBody
    public Boolean updateMenu(@RequestBody MangerMenu menu){
        return mangerMenuService.updateMenuService(menu);
    }

    //菜单栏删除
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public Boolean deleteMenu(String menuId){
        return mangerMenuService.deleteMenuService(menuId);
    }



    //查询用户
    @RequestMapping("/queryUsers")
    @ResponseBody
    public PageUtils queryUsers(@RequestBody Map<String,Object> map){
        return mangerMenuService.queryUsers(map);
    }

    //禁用用户
    @RequestMapping("/deleteUsers")
    @ResponseBody
    public Boolean deleteUsers(String userId){
        return mangerMenuService.deleteUserService(userId);
    }

    //启用用户
    @RequestMapping("/insertUsers")
    @ResponseBody
    public Boolean openUsers(String userId){


                Boolean result=mangerMenuService.openUserService(userId);
                return result;
    }
}
