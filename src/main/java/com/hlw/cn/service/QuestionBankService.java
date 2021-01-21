package com.hlw.cn.service;

import com.hlw.cn.pojo.Classify;
import com.hlw.cn.pojo.Question;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author DaiPeng
 * 时间：2021/01/21
 */

public interface QuestionBankService {

    //添加分类
    public  boolean addClassifyService(String name, String acc) ;

    //修改分类
    public boolean updateClassifyService(String id,String name,String acc);

    //查看分类
    public List<Classify> queryClassify();

    //删除分类
    public boolean deleteClassify(String id);

    //添加试题
    public boolean addQuestion(Question question);

    //修改试题
    public Question updateQuestion(Question question);

    //删除试题
    public boolean deleteQuesstion(String id);

    //查询试题

    //查询一个试题
    public Question queryQuestionId();



}
