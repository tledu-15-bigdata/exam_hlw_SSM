package com.hlw.cn.controller;


import com.hlw.cn.pojo.Classify;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.service.impl.QuestionBankImpl;
import com.hlw.cn.util.PageUtils;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public boolean addClassify(@RequestBody Classify classify){
System.out.println(classify);
        return questionBank.addClassifyService(classify.getClassifyName(),classify.getClassifyAcc());
    }


    //修改分类
    @RequestMapping("/updateClassify")
    @ResponseBody
    public boolean updateClassify(String id,String name,String acc){
        return questionBank.updateClassifyService(id, name, acc);
    }


    //查看分类  分页时
    @RequestMapping("/queryClassify")
    @ResponseBody
    public PageUtils queryClassify(@RequestBody Map<String,Object> param){
        System.out.println(param.toString());
        return questionBank.queryClassify(param);
    }

    //添加试题时拿到分类信息
    @RequestMapping("/queryClassifys")
    @ResponseBody
    public List<Classify> queryClassifys(String acc){
        System.out.println(acc);
        return questionBank.queryClassifys(acc);
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
    public boolean updateQuestion(@RequestBody Question question){
        return questionBank.updateQuestion(question);
    }

    //删除试题
    @RequestMapping("/deleteQuestion")
    @ResponseBody
    public boolean deleteQuesstion(String id){
        return questionBank.deleteQuesstion(id);
    }

    //查询一个试题
    @RequestMapping("/queryQuestionId")
    @ResponseBody
    public Question queryQuestionId(String id){
        return questionBank.queryQuestionId(id);
    }
    //查询试题
    @RequestMapping("/queryQuestion")
    @ResponseBody
    //分页处理   参数修改  原来无参数，后修改为带参数（分页数据） 原因：需要分页
    public PageUtils queryQuestion(@RequestBody Map<String,Object> param){
        return questionBank.queryQuestionAll(param);
    }
}
