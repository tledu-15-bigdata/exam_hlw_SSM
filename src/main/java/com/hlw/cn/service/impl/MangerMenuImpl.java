package com.hlw.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hlw.cn.dao.MangerMenuDao;
import com.hlw.cn.pojo.MangerMenu;
import com.hlw.cn.pojo.User;
import com.hlw.cn.service.MangerMenuService;
import com.hlw.cn.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 负责人：代朋
 */

@Service
public class MangerMenuImpl implements MangerMenuService {

    @Autowired
    private MangerMenuDao mangerMenuDao;

    //菜单栏查询
    @Override
    public Map<String,Object> queryMenuService() {
        List<MangerMenu> list1= mangerMenuDao.queryMenuOne();
        List<MangerMenu> list2= mangerMenuDao.queryMenuTwo();

        Map<String,Object> map=new HashMap<>();
        map.put("list1",list1);
        map.put("list2",list2);
        return map;

    }


    //查询所有菜单栏
    @Override
    public PageUtils queryMenuAllService(Map<String,Object> map){
        PageHelper.offsetPage(Integer.parseInt(map.get("offset").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List list=mangerMenuDao.queryMenuAll();

        PageInfo pageInfo=new PageInfo(list);
        return new PageUtils(pageInfo.getList(), new Long(pageInfo.getTotal()).intValue());


    }

    //修改菜单栏
    @Override
    public Boolean updateMenuService(MangerMenu mangerMenu) {
        return 0!=mangerMenuDao.updateMenu(mangerMenu);
    }

    //菜单栏删除
    @Override
    public Boolean deleteMenuService(String id) {
        return 0!=mangerMenuDao.deleteMenu(id);
    }



//    查询用户

    public PageUtils queryUsers(Map<String,Object> map) {

        PageHelper.offsetPage(Integer.parseInt(map.get("offset").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List list=mangerMenuDao.queryUsers();

        PageInfo<User> pageInfo=new PageInfo<>(list);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());

    }

//    禁用用户
    public Boolean deleteUserService(String id){
        return 0!=mangerMenuDao.deleteUser(id);
    }

    //启用用户
    public Boolean openUserService(String id){
        return 0!=mangerMenuDao.openUser(id);
    }





}
