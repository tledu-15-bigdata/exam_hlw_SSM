package com.hlw.cn.dao;

import com.hlw.cn.pojo.ExamAnswer;
import com.hlw.cn.pojo.Examinee;
import com.hlw.cn.pojo.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExaminationDao {

    //根据试卷号查试卷id
    public String selctTestId(String id);
    //根据试卷id查对应试卷试题
    public List<Question> selectTestPaper(String id);
    //查询单选题的选项
    public Question selectSingle(String id);
    //查询试卷标题
    public String selctTestTitle(String id);
    //插入考生信息
    public int insertExamination(Examinee examinee);
    //插入考生答案
    public int insertExamintionAnswer(ExamAnswer examAnswer);
    //插入成绩
    public  int insertFinallyScore (Examinee examinee);
}
