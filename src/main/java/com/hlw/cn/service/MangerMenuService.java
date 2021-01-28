package com.hlw.cn.service;


import com.hlw.cn.pojo.MangerMenu;
import com.hlw.cn.util.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 负责人：代朋
 */

public interface MangerMenuService {
    //查询菜单栏
    public Map<String,Object> queryMenuService();
    //菜单栏修改
    public Boolean updateMenuService(MangerMenu mangerMenu);
    //菜单栏删除
    public Boolean deleteMenuService(String id);

    //查询用户
    public PageUtils queryUsers(Map <String,Object> map);
//    删除用户
    public Boolean deleteUserService(String id);
    //开启用户
    public Boolean openUserService(String id);

}
