package com.hlw.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hlw.cn.dao.QuestionBankDao;
import com.hlw.cn.pojo.Classify;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.service.QuestionBankService;
import com.hlw.cn.util.PageUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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

System.out.println(name+acc);
        //查询该分类是否存在，若存在不允许添加
        List<Classify> classify1=questionBankDao.queryClassify2(name,acc);
        if (classify1.size()==0){
        //   新增分类
            Classify classify=new Classify(name,acc);
            classify.setClassifyId(UUID.randomUUID().toString());
            classify.setClassifyCreatetime(LocalDateTime.now());
            classify.setClassifyIsdelete(1);

System.out.println(classify.getClassifyId());

            //返回受影响行数
            int i=questionBankDao.insertClassify(classify);
            if(i!=0)return true;
        }
        return false;
    }



    //修改分类
    @Override
    public boolean updateClassifyService(String id, String name, String acc) {
        if (id!=null){
            //查询该分类是否存在，若存在不允许添加
            List<Classify> classify=questionBankDao.queryClassify2(name,acc);
            if (classify.size()==0){
                //修改分类
                int i=questionBankDao.updateClassify(new Classify(id,name,acc));
                if(i!=0) return true;
            }
        }

        return false;
    }

    //查询分类
    @Override
    public PageUtils queryClassify(Map<String,Object> param) {

        PageHelper.offsetPage(Integer.parseInt(param.get("offset").toString()),Integer.parseInt(param.get("pageNumber").toString()));
        //接收数据库数据
        List<Classify> list=null;
        if (param.get("acc").toString()!=null){
            list= questionBankDao.queryClassify1(param.get("acc").toString());
            System.out.println(list);
        }

        PageInfo<Classify> pageInfo=new PageInfo<Classify>(list);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }

    //删除分类
    @Override
    public boolean deleteClassify(String id) {
        if (id!=null){
            int i=questionBankDao.deleteClassify(id);
            if (i!=0) return true;
        }

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
        Question q=null;
        if (question.getQuestionId()!=null){
            //修改
            questionBankDao.updateQuestion1(question);
            questionBankDao.updateQuestion2(question);
            q=queryQuestionId(question.getQuestionId());
        }

        return q;
    }

    //删除试题
    @Override
    public boolean deleteQuesstion(String id) {
        int i=0;
        if (id!=null){
            i=questionBankDao.deleteQuestion(id);
            if (i!=0)return true;
        }

        return false;
    }

    //查询一个试题
    @Override
    public Question queryQuestionId(String id) {
        Question question=null,tempq;
        if (id!=null){
            question=questionBankDao.queryQuestionOne1(id);
            tempq=questionBankDao.queryQuestionOne2(id);
            question.setSingleA(tempq.getSingleA());
            question.setSingleB(tempq.getSingleB());
            question.setSingleC(tempq.getSingleC());
            question.setSingleD(tempq.getSingleD());
        }

        return question;
    }


    //查询试题


    @Override
    public PageUtils queryQuestionAll(Map<String,Object> param) {
        PageHelper.offsetPage(Integer.parseInt(param.get("offset").toString()),Integer.parseInt(param.get("pageNumber").toString()));
        //接收数据库数据
        List<Question> list=null;
        if (param.get("questionId").toString()!=null){
            list= questionBankDao.queryQuestionAll(param.get("acc").toString());
            for (Question q:list){
                Question qtemp=questionBankDao.queryQuestionOne2(q.getQuestionId());
                q.setSingleA(qtemp.getSingleA());
                q.setSingleB(qtemp.getSingleB());
                q.setSingleC(qtemp.getSingleC());
                q.setSingleD(qtemp.getSingleD());
            }
System.out.println(list);
        }


        PageInfo<Question> pageInfo=new PageInfo<>(list);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }
}
