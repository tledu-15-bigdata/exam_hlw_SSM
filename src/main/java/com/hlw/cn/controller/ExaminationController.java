package com.hlw.cn.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hlw.cn.pojo.ExamAnswer;
import com.hlw.cn.pojo.Examinee;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.service.ExaminationService;
import com.hlw.cn.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    //根据试卷号返回试题
    @RequestMapping("/inputTestNumber")
    @ResponseBody
    public Map<String,Object> inputTestNumber(@RequestBody Map<String,Object> map){
        return examinationService.selectTestPaper(String.valueOf(map.get("examId")) );
    }

    //插入考生信息
    @RequestMapping("/insertExamiee")
    @ResponseBody
    public Boolean insertExamiee(@RequestBody Examinee examinee){
        return examinationService.insertExamineeService(examinee);
    }

    @RequestMapping("/submitTestPaper")
    @ResponseBody
    //接收答案
    public boolean submitTestPaper( @RequestBody ListUtil list){


        return examinationService.submitTestPaperService((List<ExamAnswer>) list);
    }
}
