package com.hlw.cn.service;

import com.hlw.cn.dao.ExaminationDao;
import com.hlw.cn.pojo.ExamAnswer;
import com.hlw.cn.pojo.Examinee;
import com.hlw.cn.pojo.Question;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ExaminationService {

    @Autowired
    ExaminationDao examinationDao;

    //根据是试卷号查id
    public Map<String,Object> selectTestPaper(String paperNumber){
        Map<String,Object> map=new HashMap<>();

        //查询试题
        List<Question> list=examinationDao.selectTestPaper(examinationDao.selctTestId(paperNumber));
        //插入单选题
        for (Question q:list){
            if (q.getQuestionType()==0){
                Question qtemp= (Question) examinationDao.selectSingle(q.getQuestionId());
                q.setSingleA(qtemp.getSingleA());
                q.setSingleB(qtemp.getSingleB());
                q.setSingleC(qtemp.getSingleC());
                q.setSingleD(qtemp.getSingleD());
            }
        }
        map.put("list",list);

        //查询试卷题目
        map.put("title",examinationDao.selctTestTitle(paperNumber));
        return map;
    }

    //插入考生信息
    public Boolean insertExamineeService(Examinee examinee){
        Examinee examinee1=new Examinee();

        examinee1.setExamineeId(UUID.randomUUID().toString());
        examinee1.setExamineeName(examinee.getExamineeName());
        examinee1.setExamineePhone(examinee.getExamineePhone());
        examinee1.setExamineeCreatetime(LocalDateTime.now());
        examinee1.setExamineeIsdelete("1");

        int i=examinationDao.insertExamination(examinee1);
        //受影响行数大于零说明插入成功
        if (i!=0)return true;
        return false;
    }

    //接收考生答案
    public Boolean submitTestPaperService(List<ExamAnswer> examAnswers){
        //答案表uuid
        String uuid= UUID.randomUUID().toString();
        //答案生成时间
        LocalDateTime localDateTime=LocalDateTime.now();
        //总分
        int sumScore=0;

        //插入数据库
        for (ExamAnswer examAnswer : examAnswers){
            //写入uuid和生成时间
            examAnswer.setExamanswerId(uuid);
            examAnswer.setExamanswerCreattime(localDateTime);

            //计算是否得分
            if (examAnswer.getExamanswerTrueanswer().equals(examAnswer.getExamanswerExamineeanswer())){
                sumScore=sumScore+examAnswer.getExamanswerScore();
            }
            //入库
            int i=examinationDao.insertExamintionAnswer(examAnswer);
            if (i!=0) System.out.println(examAnswer.getExamanswerId()+"入库成功");
            else {
                System.out.println(examAnswer.getExamanswerId()+"入库失败");
                return false;
            }
        }

        //插入成绩
        Examinee examinee=new Examinee();
        examinee.setExamineePhone(examAnswers.get(0).getExamanswerPhone());
        examinee.setExamineeTestid(examAnswers.get(0).getExamanswerTestid());
        examinee.setExamineeScore(new String(String.valueOf(sumScore)));
        int i=examinationDao.insertFinallyScore(examinee);

        if (i!=0) System.out.println("成绩入库成功");
        else {return false;}



        return true;

    }
}
