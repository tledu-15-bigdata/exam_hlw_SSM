package com.hlw.cn.dao;

import com.hlw.cn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    //注册时验证账号是否存在 存在返回1 不存在返回0
    public int validateAcc(String acc);

    //注册时验证手机号是否存在 存在返回1 不存在返回0
    public int validatePhone(String phone);

    //将用户注册信息存入数据库
    public int registerUser(User user);

    //登录时验证账号密码并返回登录用户信息
    public User validateUser(User user);
}
