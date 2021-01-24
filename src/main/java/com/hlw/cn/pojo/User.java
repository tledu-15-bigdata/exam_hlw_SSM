package com.hlw.cn.pojo;

public class User {
    //用户id
    private String userId;
    //用户名
    private String userName;
    //用户账号
    private String userAcc;
    //用户密码
    private String userPwd;
    //用户邮箱
    private String userEmail;
    //用户手机号
    private String userPhone;
    //用户头像路径
    private String userHeadsrc;
    //创建时间
    private String userCreatetime;
    //本条数据是否存在  存在为1  不存在为0
    private String userIsdelete;

    public User() {
    }


    public User(String userId, String userName, String userAcc, String userPwd, String userEmail, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userAcc = userAcc;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcc() {
        return userAcc;
    }

    public void setUserAcc(String userAcc) {
        this.userAcc = userAcc;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserHeadsrc() {
        return userHeadsrc;
    }

    public void setUserHeadsrc(String userHeadsrc) {
        this.userHeadsrc = userHeadsrc;
    }

    public String getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(String userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    public String getUserIsdelete() {
        return userIsdelete;
    }

    public void setUserIsdelete(String userIsdelete) {
        this.userIsdelete = userIsdelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAcc='" + userAcc + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userHeadsrc='" + userHeadsrc + '\'' +
                ", userCreatetime='" + userCreatetime + '\'' +
                ", userIsdelete='" + userIsdelete + '\'' +
                '}';
    }
}
