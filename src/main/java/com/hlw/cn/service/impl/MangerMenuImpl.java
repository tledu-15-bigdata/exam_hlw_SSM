package com.hlw.cn.service.impl;

import com.hlw.cn.dao.MangerMenuDao;
import com.hlw.cn.pojo.MangerMenu;
import com.hlw.cn.service.MangerMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 负责人：代朋
 */

@Service
public class MangerMenuImpl implements MangerMenuService {

    @Autowired
    private MangerMenuDao mangerMenuDao;

    //菜单栏查询
    @Override
    public List<MangerMenu> queryMenuService() {
        return mangerMenuDao.queryMenu();
    }
}
