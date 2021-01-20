package com.hlw.cn.service;

import com.hlw.cn.pojo.User;

public interface UserService {

    //注册时验证账号是否存在 存在返回false 不存在返回true
     Boolean validateAcc(String acc);

    //注册时验证手机号是否存在 存在返回false 不存在返回true
     Boolean validatePhone(String phone);

    //注册用户
     Boolean registerUser(User user);

    //用户登录验证  返回用户信息
     User validateUser(User user);

}
