package com.hlw.cn.pojo;

/**
 * 负责人：代朋
 */

public class MangerMenu {
    //菜单栏id
    private String menuId;
    //菜单栏名称
    private String menuName;
    //菜单栏上一级
    private String menuUp;
    //菜单栏创建时间
    private String menuCreatetime;
    //菜单栏是否删除   1存在  0不存在
    private String menuIsdelete;


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUp() {
        return menuUp;
    }

    public void setMenuUp(String menuUp) {
        this.menuUp = menuUp;
    }

    public String getMenuCreatetime() {
        return menuCreatetime;
    }

    public void setMenuCreatetime(String menuCreatetime) {
        this.menuCreatetime = menuCreatetime;
    }

    public String getMenuIsdelete() {
        return menuIsdelete;
    }

    public void setMenuIsdelete(String menuIsdelete) {
        this.menuIsdelete = menuIsdelete;
    }

    @Override
    public String toString() {
        return "MangerMenu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuUp='" + menuUp + '\'' +
                ", menuCreatetime='" + menuCreatetime + '\'' +
                ", menuIsdelete='" + menuIsdelete + '\'' +
                '}';
    }
}
