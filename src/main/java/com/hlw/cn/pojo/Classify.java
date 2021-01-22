package com.hlw.cn.pojo;

import java.time.LocalDateTime;

/**
 * @author DaiPeng
 * 时间：2021/01/21
 */

public class Classify {
    //分类id
    private String classifyId;
    //分类名称
    private String classifyName;
    //分类的账户
    private String classifyAcc;
    //分类创建时间
    private LocalDateTime classifyCreatetime;
    //分类是否删除 1没有删除，0删除
    private int classifyIsdelete;

    public Classify(){}

    public Classify(String name,String acc){
        this.classifyName=name;
        this.classifyAcc=acc;
    }

    public Classify(String id,String name,String acc){
        this.classifyId=id;
        this.classifyName=name;
        this.classifyAcc=acc;
    }


    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyAcc() {
        return classifyAcc;
    }

    public void setClassifyAcc(String classifyAcc) {
        this.classifyAcc = classifyAcc;
    }



    public void setClassifyCreatetime(LocalDateTime classifyCreatetime) {
        this.classifyCreatetime = classifyCreatetime;
    }

    public int getClassifyIsdelete() {
        return classifyIsdelete;
    }

    public void setClassifyIsdelete(int classifyIsdelete) {
        this.classifyIsdelete = classifyIsdelete;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "classifyId='" + classifyId + '\'' +
                ", classifyName='" + classifyName + '\'' +
                ", classifyAcc='" + classifyAcc + '\'' +
                ", classifyCreatetime=" + classifyCreatetime +
                ", classifyIsdelete=" + classifyIsdelete +
                '}';
    }
}
