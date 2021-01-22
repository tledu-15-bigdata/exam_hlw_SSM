package com.hlw.cn.controller;


import com.hlw.cn.pojo.Classify;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.service.impl.QuestionBankImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 负责人:：代朋
 */

@Controller
public class QuestionBankController {

    @Autowired
    private QuestionBankImpl questionBank;

    //添加分类
    @RequestMapping("/addClassify")
    @ResponseBody
    public boolean addClassify(String acc,String name){
        return questionBank.addClassifyService(acc,name);
    }

    //修改分类
    @RequestMapping("/updateClassify")
    @ResponseBody
    public boolean updateClassify(String id,String name,String acc){
        return questionBank.updateClassifyService(id, name, acc);
    }

    //查看分类
    @RequestMapping("/queryClassify")
    @ResponseBody
    public List<Classify> queryClassify(){
        return questionBank.queryClassify();
    }

    //删除分类
    @RequestMapping("/deleteClassify")
    @ResponseBody
    public boolean deleteClassify(String id){
        return questionBank.deleteClassify(id);
    }

    //添加试题
    @RequestMapping("/addQuestion")
    @ResponseBody
    public boolean addQuestion(@RequestBody Question question){
        return questionBank.addQuestion(question);
    }

    //修改试题
    @RequestMapping("/updateQuestion")
    @ResponseBody
    public Question updateQuestion(@RequestBody Question question){
        return questionBank.updateQuestion(question);
    }

    //删除试题
    @RequestMapping("/deleteQuestion")
    @ResponseBody
    public boolean deleteQuesstion(String id){
        return questionBank.deleteQuesstion(id);
    }

    //查询试题
//    @RequestMapping("/queryQuestion")
//    @ResponseBody
    //分页处理

    //查询一个试题
    @RequestMapping("/queryQuestionId")
    @ResponseBody
    public Question queryQuestionId(String id){
        return questionBank.queryQuestionId(id);
    }
}
