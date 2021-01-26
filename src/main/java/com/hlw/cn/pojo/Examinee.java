package com.hlw.cn.pojo;

import java.time.LocalDateTime;

public class Examinee {
    //考生信息
    private String examineeId;
    private String examineeName;
    private String examineePhone;
    private String examineeTestid;
    private String examineeScore;
    private LocalDateTime examineeCreatetime;
    private String examineeIsdelete;

    public String getExamineeId() {
        return examineeId;
    }

    public void setExamineeId(String examineeId) {
        this.examineeId = examineeId;
    }

    public String getExamineeName() {
        return examineeName;
    }

    public void setExamineeName(String examineeName) {
        this.examineeName = examineeName;
    }

    public String getExamineePhone() {
        return examineePhone;
    }

    public void setExamineePhone(String examineePhone) {
        this.examineePhone = examineePhone;
    }

    public String getExamineeTestid() {
        return examineeTestid;
    }

    public void setExamineeTestid(String examineeTestid) {
        this.examineeTestid = examineeTestid;
    }

    public String getExamineeScore() {
        return examineeScore;
    }

    public void setExamineeScore(String examineeScore) {
        this.examineeScore = examineeScore;
    }

    public LocalDateTime getExamineeCreatetime() {
        return examineeCreatetime;
    }

    public void setExamineeCreatetime(LocalDateTime examineeCreatetime) {
        this.examineeCreatetime = examineeCreatetime;
    }

    public String getExamineeIsdelete() {
        return examineeIsdelete;
    }

    public void setExamineeIsdelete(String examineeIsdelete) {
        this.examineeIsdelete = examineeIsdelete;
    }

    @Override
    public String toString() {
        return "Examinee{" +
                "examineeId='" + examineeId + '\'' +
                ", examineeName='" + examineeName + '\'' +
                ", examineePhone='" + examineePhone + '\'' +
                ", examineeTestid='" + examineeTestid + '\'' +
                ", examineeScore='" + examineeScore + '\'' +
                ", examineeCreatetime='" + examineeCreatetime + '\'' +
                ", examineeIsdelete='" + examineeIsdelete + '\'' +
                '}';
    }
}
