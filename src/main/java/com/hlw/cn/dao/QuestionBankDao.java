package com.hlw.cn.dao;

import com.hlw.cn.pojo.Classify;
import com.hlw.cn.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Daipeng
 */
@Mapper
public interface QuestionBankDao {

    //插入分类
    public int insertClassify(Classify classify);

    //修改分类
    public int updateClassify(Classify classify);

    //查询分类
    public List<Classify> queryClassify1(@Param("acc") String acc);
    public List<Classify> queryClassify2(@Param("name") String name, @Param("acc") String acc);

    //删除分类
    public int deleteClassify(String id);


    //添加试题
    public int insertQuestion1(Question question);
    public int insertQuestion2(Question question);

    //修改试题
    public int updateQuestion1(Question question);
    public int updateQuestion2(Question question);

    //删除试题
    public int deleteQuestion(String id);

    //查询一个试题
    public Question queryQuestionOne1(String id);
    public Question queryQuestionOne2(String id);

    //分页查询试题
    public List<Question> queryQuestionAll(String acc);

}
