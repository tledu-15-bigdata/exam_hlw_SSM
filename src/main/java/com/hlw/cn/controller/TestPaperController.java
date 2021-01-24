package com.hlw.cn.controller;

import com.hlw.cn.pojo.*;
import com.hlw.cn.service.TestPaperService;
import com.hlw.cn.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 负责人:：吴宣虎
 */

@Controller
public class TestPaperController {

    private TestPaperService testPaperService;

    //查看分组  分页
    @RequestMapping("/queryGroup")
    @ResponseBody
    public PageUtils queryClassify(@RequestBody Map<String,Object> param){
        System.out.println(param.toString());

        return testPaperService.queryGroup(param);
    }

    //添加分组
    @RequestMapping("/addGroup")
    @ResponseBody
    public boolean addGroup(@RequestBody Group group){

        return testPaperService.addGroup(group);
    }

    //修改分组
    @RequestMapping("/updateGroup")
    @ResponseBody
    public boolean updateGroup(@RequestBody Group group){

        return testPaperService.updateGroup(group);
    }

    //删除分组
    @RequestMapping("/deleteGroup")
    @ResponseBody
    public boolean deleteGroup(@RequestBody Group group){

        return testPaperService.deleteGroup(group);
    }

    //添加试卷
    @RequestMapping("/addTestPaper")
    @ResponseBody
    public Map<String, Object> addTestPaper(@RequestBody TestPaper testPaper){

        return testPaperService.addTestPaper(testPaper);
    }

    //查询所有试卷信息
    @RequestMapping("/queryTestPaper")
    @ResponseBody
    public PageUtils queryTestPaper(@RequestBody Map<String,Object> param){
        System.out.println(param.toString());

        return testPaperService.queryTestPaper(param);
    }

    //返回题库中的试题数据  分页
    @RequestMapping("/queryTestPaperQuestion")
    @ResponseBody
    public PageUtils queryTestPaperQuestion(@RequestBody Map<String,Object> param){
        System.out.println(param.toString());

        return testPaperService.queryTestPaperQuestion(param);
    }

    //对应试卷中添加试题
    @RequestMapping("/addTestPaperQuestion")
    @ResponseBody
    public boolean addTestPaperQuestion(@RequestBody SelectQuestion selectQuestion){

        return testPaperService.addTestPaperQuestion(selectQuestion);
    }

    //返回对应试卷中的试题数据  返回map
    @RequestMapping("/queryTestQuestion")
    @ResponseBody
    public Map<String,Object> queryTestQuestion(@RequestBody TestPaper testPaper){

        return testPaperService.queryTestQuestion(testPaper);
    }

    //删除试卷
    @RequestMapping("/deleteTestPaper")
    @ResponseBody
    public boolean deleteTestPaper(@RequestBody TestPaper testPaper){

        return testPaperService.deleteTestPaper(testPaper);
    }

    //删除对应试卷下的试题
    @RequestMapping("/deleteTestQuestion")
    @ResponseBody
    public boolean deleteTestQuestion(@RequestBody Question question){

        return testPaperService.deleteTestQuestion(question);
    }

    //添加试卷生成后的路径
    @RequestMapping("/addTestUrl")
    @ResponseBody
    public boolean addTestUrl(@RequestBody TestPaper testPaper){

        return testPaperService.addTestUrl(testPaper);
    }


}
