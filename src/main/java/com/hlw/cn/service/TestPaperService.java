package com.hlw.cn.service;

import com.hlw.cn.pojo.Group;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.pojo.SelectQuestion;
import com.hlw.cn.pojo.TestPaper;
import com.hlw.cn.util.PageUtils;

import java.util.Map;

public interface TestPaperService {

    //查询分组  分页显示
    PageUtils queryGroup(Map<String,Object> param);

    //添加分组
    boolean addGroup (Group group);

    //修改分组
    boolean updateGroup(Group group);

    //删除分组
    boolean deleteGroup(Group group);


    //查询所有的试卷信息
    PageUtils queryTestPaper(Map<String,Object> param);

    //添加试卷
    Map<String,Object> addTestPaper(TestPaper testPaper);

    //往试卷中添加试题
    PageUtils queryTestPaperQuestion(Map<String,Object> param);

    //添加试卷
    boolean addTestPaperQuestion(SelectQuestion selectQuestion);

    //返回对应试卷中的试题数据  返回map
    Map<String,Object> queryTestQuestion(TestPaper testPaper);

    //删除试卷
    boolean deleteTestPaper(TestPaper testPaper);

    //删除对应试卷下的试题
    boolean deleteTestQuestion(Question question);

    //添加试卷生成后的路径
    boolean addTestUrl(TestPaper testPaper);
}
