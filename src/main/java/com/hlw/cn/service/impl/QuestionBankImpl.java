package com.hlw.cn.service.impl;

import com.hlw.cn.dao.QuestionBankDao;
import com.hlw.cn.pojo.Classify;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 负责人：代朋
 */

@Service
public class QuestionBankImpl implements QuestionBankService {
    @Autowired
    private QuestionBankDao questionBankDao;

    //添加分类
    @Override
    public boolean addClassifyService(String name, String acc) {

        Classify classify=new Classify(name,acc);
        classify.setClassifyId(UUID.randomUUID().toString());
        classify.setClassifyCreatetime(LocalDateTime.now());
        classify.setClassifyIsdelete(1);

        //返回受影响行数
        int i=questionBankDao.insertClassify(classify);
        if(i!=0)return true;

        return false;
    }

    //修改分类
    @Override
    public boolean updateClassifyService(String id, String name, String acc) {
        //查询该分类是否存在，若存在不允许添加
        Classify classify=questionBankDao.queryClassify(name);
        if (classify!=null){
            //修改分类
            int i=questionBankDao.updateClassify(new Classify(id,name,acc));
            if(i!=0) return true;
        }

        return false;
    }

    //查询分类
    @Override
    public List<Classify> queryClassify() {
        List<Classify> list=questionBankDao.queryClassify();
        return list;
    }

    //删除分类
    @Override
    public boolean deleteClassify(String id) {
        int i=questionBankDao.deleteClassify(id);
        if (i!=0) return true;
        return false;
    }


    //添加试题
    @Override
    public boolean addQuestion(Question question) {
        int i=0,j=0;

        question.setQuestionId(UUID.randomUUID().toString());
        question.setQuestionCreatetime(LocalDateTime.now());
        question.setQuestionIsdelete(1);
        //插入数据
        i=questionBankDao.insertQuestion1(question);
        if (question.getQuestionType()==0)
            {
                j=questionBankDao.insertQuestion2(question);
                if (i!=0&&j!=0)return true;
            }
        //如果是简单题 插入完返回
        if (question.getQuestionType()==1&&i!=0)return true;

        return false;
    }

    //修改试题
    @Override
    public Question updateQuestion(Question question) {
        Question q;
        //修改
        questionBankDao.updateQuestion1(question);
        questionBankDao.updateQuestion2(question);
        q=queryQuestionId(question.getQuestionId());
        return q;
    }

    //删除试题
    @Override
    public boolean deleteQuesstion(String id) {
        int i=0;
        i=questionBankDao.deleteQuestion(id);
        if (i!=0)return true;
        return false;
    }

    //查询一个试题
    @Override
    public Question queryQuestionId(String id) {
        Question question,tempq;
        question=questionBankDao.queryQuestionOne1(id);
        tempq=questionBankDao.queryQuestionOne2(id);
        question.setSingleA(tempq.getSingleA());
        question.setSingleB(tempq.getSingleB());
        question.setSingleC(tempq.getSingleC());
        question.setSingleD(tempq.getSingleD());
        return question;
    }
}
