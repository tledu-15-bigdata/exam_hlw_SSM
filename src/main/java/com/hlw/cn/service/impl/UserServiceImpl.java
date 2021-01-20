package com.hlw.cn.service.impl;

import com.hlw.cn.dao.UserDao;
import com.hlw.cn.pojo.User;
import com.hlw.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//实例化userDao

//  验证账号是否已经存在  返回值为true时表示当前账号没有被注册  flase表示已经被注册
    @Override
    public Boolean validateAcc(String acc) {
        Boolean flag = true;

        if (userDao.validateAcc(acc)==1){
            flag=false;
        }
        return flag;
    }

//  验证手机号是否已经存在  返回值为true时表示当前手机号没有被注册  flase表示已经被注册
    @Override
    public Boolean validatePhone(String phone) {
        Boolean flag = true;
        if (userDao.validatePhone(phone)==1){
            flag=false;
        }
        return flag;
    }

//   将用户信息存入数据库   存入成功返回true 失败返回false
    @Override
    public Boolean registerUser(User user) {
        Boolean flag = false;
        if (userDao.registerUser(user)==1){
            flag=true;
        }
        return flag;
    }

//    登录时验证用户信息  返回用户数据用于前端验证
    @Override
    public User validateUser(User user) {

        return userDao.validateUser(user);
    }


}
