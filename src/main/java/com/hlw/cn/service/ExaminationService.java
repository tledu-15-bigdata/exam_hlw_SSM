package com.hlw.cn.service;

import com.hlw.cn.dao.ExaminationDao;
import com.hlw.cn.pojo.Examinee;
import com.hlw.cn.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationService {

    @Autowired
    ExaminationDao examinationDao;

    //根据是试卷号查id
    public List<Question> selectTestPaper(String paperNumber){

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

        return list;
    }

    //插入考生信息
    public Boolean insertExamineeService(Examinee examinee){

    }
}
