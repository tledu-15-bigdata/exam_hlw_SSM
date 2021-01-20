package com.hlw.cn.pojo;

public class User {
    private String userId;
    private String userName;
    private String userAcc;
    private String userPwd;
    private String userEmail;
    private String userPhone;
    private String userHeadsrc;
    private String userCreatetime;
    private String userIsdelete;

    public User() {
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
