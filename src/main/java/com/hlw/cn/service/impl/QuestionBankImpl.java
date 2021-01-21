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

    @Override
    public boolean updateClassifyService(String id, String name, String acc) {
        return false;
    }

    @Override
    public List<Classify> queryClassify() {
        return null;
    }

    @Override
    public boolean deleteClassify(String id) {
        return false;
    }

    @Override
    public boolean addQuestion(Question question) {
        return false;
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    @Override
    public boolean deleteQuesstion(String id) {
        return false;
    }

    @Override
    public Question queryQuestionId() {
        return null;
    }
}
