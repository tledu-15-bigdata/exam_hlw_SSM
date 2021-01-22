package com.hlw.cn.dao;

import com.hlw.cn.pojo.MangerMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 负责人：代朋
 */

@Mapper
public interface MangerMenuDao {
    //查询菜单栏
    public List<MangerMenu> queryMenu();
}
