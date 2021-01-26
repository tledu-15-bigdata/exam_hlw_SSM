package com.hlw.cn.controller;

import com.hlw.cn.pojo.Examinee;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.service.ExaminationService;
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
    public List<Question> inputTestNumber(@RequestBody Map<String,Object> map){
        return examinationService.selectTestPaper((String) map.get("examId"));
    }

    //插入考生信息
    @RequestMapping("/insertExamiee")
    @ResponseBody
    public Boolean insertExamiee(@RequestBody Examinee examinee){
        return examinationService.insertExamineeService(examinee);
    }
}
