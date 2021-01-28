package com.hlw.cn.dao;

import com.hlw.cn.pojo.MangerMenu;
import com.hlw.cn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 负责人：代朋
 */

@Mapper
public interface MangerMenuDao {
    //查询菜单栏
    public List<MangerMenu> queryMenuOne();
    public List<MangerMenu> queryMenuTwo();

    //修改菜单
    public int updateMenu(MangerMenu mangerMenu);

    //删除菜单
    public int deleteMenu(String menuId);


    //查询用户
    public List<User> queryUsers();

    //禁用用户
    public int deleteUser(String userId);

    //启用用户
    public int openUser(String userId);
}
