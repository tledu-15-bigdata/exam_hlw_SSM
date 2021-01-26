package com.hlw.cn.dao;

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
    public List<Question> selectSingle(String id);
}
