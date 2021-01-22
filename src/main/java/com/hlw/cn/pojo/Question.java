package com.hlw.cn.pojo;

import java.time.LocalDateTime;

/**
 * @author DaiPeng
 * 时间：2021/01/21
 */
public class Question {
    //试题id
    private String questionId;
    //试题题目
    private String questionTopic;
    //试题成绩
    private int questionScore;
    //试题答案
    private String questionAnswer;
    //试题分类
    private String questionClassify;
    //试题账户
    private String questionAcc;
    //试题创建时间
    private LocalDateTime questionCreatetime;
    //是否删除 1表示存在 0表示不存在
    private int questionIsdelete;
    //试题类型  0单选 1简答
    private int questionType;


    //单选题选项
    private String singleA;
    private String singleB;
    private String singleC;
    private String singleD;


    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTopic() {
        return questionTopic;
    }

    public void setQuestionTopic(String questionTopic) {
        this.questionTopic = questionTopic;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionClassify() {
        return questionClassify;
    }

    public void setQuestionClassify(String questionClassify) {
        this.questionClassify = questionClassify;
    }

    public String getQuestionAcc() {
        return questionAcc;
    }

    public void setQuestionAcc(String questionAcc) {
        this.questionAcc = questionAcc;
    }

    public LocalDateTime getQuestionCreatetime() {
        return questionCreatetime;
    }

    public void setQuestionCreatetime(LocalDateTime questionCreatetime) {
        this.questionCreatetime = questionCreatetime;
    }

    public int getQuestionIsdelete() {
        return questionIsdelete;
    }

    public void setQuestionIsdelete(int questionIsdelete) {
        this.questionIsdelete = questionIsdelete;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getSingleA() {
        return singleA;
    }

    public void setSingleA(String singleA) {
        this.singleA = singleA;
    }

    public String getSingleB() {
        return singleB;
    }

    public void setSingleB(String singleB) {
        this.singleB = singleB;
    }

    public String getSingleC() {
        return singleC;
    }

    public void setSingleC(String singleC) {
        this.singleC = singleC;
    }

    public String getSingleD() {
        return singleD;
    }

    public void setSingleD(String singleD) {
        this.singleD = singleD;
    }


    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", questionTopic='" + questionTopic + '\'' +
                ", questionScore=" + questionScore +
                ", questionAnswer='" + questionAnswer + '\'' +
                ", questionClassify='" + questionClassify + '\'' +
                ", questionAcc='" + questionAcc + '\'' +
                ", questionCreatetime=" + questionCreatetime +
                ", questionIsdelete=" + questionIsdelete +
                ", questionType=" + questionType +
                ", singleA='" + singleA + '\'' +
                ", singleB='" + singleB + '\'' +
                ", singleC='" + singleC + '\'' +
                ", singleD='" + singleD + '\'' +
                '}';
    }
}
