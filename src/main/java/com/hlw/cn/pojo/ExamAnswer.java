package com.hlw.cn.pojo;

import java.time.LocalDateTime;

public class ExamAnswer {
    //考生答案新消息
    private String examanswerId;
    private String examanswerTestid;
    private String examanswerPhone;
    private String examanswerTrueanswer;
    private String examanswerExamineeanswer;
    private int examanswerScore;
    private String examanswerQuestionid;
    private LocalDateTime examanswerCreattime;
    private  String examanswerIsdelete;


    public String getExamanswerId() {
        return examanswerId;
    }

    public void setExamanswerId(String examanswerId) {
        this.examanswerId = examanswerId;
    }

    public String getExamanswerTestid() {
        return examanswerTestid;
    }

    public void setExamanswerTestid(String examanswerTestid) {
        this.examanswerTestid = examanswerTestid;
    }

    public String getExamanswerPhone() {
        return examanswerPhone;
    }

    public void setExamanswerPhone(String examanswerPhone) {
        this.examanswerPhone = examanswerPhone;
    }

    public String getExamanswerTrueanswer() {
        return examanswerTrueanswer;
    }

    public void setExamanswerTrueanswer(String examanswerTrueanswer) {
        this.examanswerTrueanswer = examanswerTrueanswer;
    }

    public String getExamanswerExamineeanswer() {
        return examanswerExamineeanswer;
    }

    public void setExamanswerExamineeanswer(String examanswerExamineeanswer) {
        this.examanswerExamineeanswer = examanswerExamineeanswer;
    }

    public int getExamanswerScore() {
        return examanswerScore;
    }

    public void setExamanswerScore(int examanswerScore) {
        this.examanswerScore = examanswerScore;
    }

    public String getExamanswerQuestionid() {
        return examanswerQuestionid;
    }

    public void setExamanswerQuestionid(String examanswerQuestionid) {
        this.examanswerQuestionid = examanswerQuestionid;
    }

    public LocalDateTime getExamanswerCreattime() {
        return examanswerCreattime;
    }

    public void setExamanswerCreattime(LocalDateTime examanswerCreattime) {
        this.examanswerCreattime = examanswerCreattime;
    }

    public String getExamanswerIsdelete() {
        return examanswerIsdelete;
    }

    public void setExamanswerIsdelete(String examanswerIsdelete) {
        this.examanswerIsdelete = examanswerIsdelete;
    }

    @Override
    public String toString() {
        return "ExamAnswer{" +
                "examanswerId='" + examanswerId + '\'' +
                ", examanswerTestid='" + examanswerTestid + '\'' +
                ", examanswerPhone='" + examanswerPhone + '\'' +
                ", examanswerTrueanswer='" + examanswerTrueanswer + '\'' +
                ", examanswerExamineeanswer='" + examanswerExamineeanswer + '\'' +
                ", examanswerScore='" + examanswerScore + '\'' +
                ", examanswerQuestionid='" + examanswerQuestionid + '\'' +
                ", examanswerCreattime='" + examanswerCreattime + '\'' +
                ", examanswerIsdelete='" + examanswerIsdelete + '\'' +
                '}';
    }
}
