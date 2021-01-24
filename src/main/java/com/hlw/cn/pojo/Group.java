package com.hlw.cn.pojo;

public class Group {
    //分组id
    private String  groupId;
    //分组名称
    private String  groupName;
    //与用户账号绑定
    private String  groupAcc;
    //创建时间
    private String  groupCreatetime;
    //是否存在 1存在  0不存在
    private String  groupIsdelete;

    public Group() {
    }

    public Group(String groupId, String groupName, String groupAcc, String groupCreatetime, String groupIsdelete) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupAcc = groupAcc;
        this.groupCreatetime = groupCreatetime;
        this.groupIsdelete = groupIsdelete;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAcc() {
        return groupAcc;
    }

    public void setGroupAcc(String groupAcc) {
        this.groupAcc = groupAcc;
    }

    public String getGroupCreatetime() {
        return groupCreatetime;
    }

    public void setGroupCreatetime(String groupCreatetime) {
        this.groupCreatetime = groupCreatetime;
    }

    public String getGroupIsdelete() {
        return groupIsdelete;
    }

    public void setGroupIsdelete(String groupIsdelete) {
        this.groupIsdelete = groupIsdelete;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupAcc='" + groupAcc + '\'' +
                ", groupCreatetime='" + groupCreatetime + '\'' +
                ", groupIsdelete='" + groupIsdelete + '\'' +
                '}';
    }
}
