package com.hlw.cn.pojo;

public class ExamAnswer {
    //考生答案新消息
    private String examanswerId;
    private String examanswerTestid;
    private String examanswerPhone;
    private String examanswerTrueanswer;
    private String examanswerExamineeanswer;
    private String examanswerScore;
    private String examanswerQuestionid;
    private  String examanswerCreattime;
    private  String examanswerIsdelete;


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
