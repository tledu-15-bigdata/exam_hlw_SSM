package com.hlw.cn.pojo;

import java.util.List;

public class SelectQuestion {

    private List<String> ulist;
    private String questionAcc;
    private String questionId;

    public SelectQuestion() {
    }

    public SelectQuestion(List<String> ulist, String questionAcc, String questionId) {
        this.ulist = ulist;
        this.questionAcc = questionAcc;
        this.questionId = questionId;
    }

    public List<String> getUlist() {
        return ulist;
    }

    public void setUlist(List<String> ulist) {
        this.ulist = ulist;
    }

    public String getQuestionAcc() {
        return questionAcc;
    }

    public void setQuestionAcc(String questionAcc) {
        this.questionAcc = questionAcc;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "SelectQuestion{" +
                "ulist=" + ulist +
                ", questionAcc='" + questionAcc + '\'' +
                ", questionId='" + questionId + '\'' +
                '}';
    }
}
