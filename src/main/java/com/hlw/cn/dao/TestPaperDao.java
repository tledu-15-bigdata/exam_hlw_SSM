package com.hlw.cn.dao;

import com.hlw.cn.pojo.Group;
import com.hlw.cn.pojo.Question;
import com.hlw.cn.pojo.TestPaper;
import com.hlw.cn.pojo.TestQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestPaperDao {

    //查询分组  分页查询
    List<Group> queryGroupALl(String acc);
    //查询分组是否存在  用于插入时 同名分组验证
    int queryGroup(Group group);

    //添加分组
    int insertGroup(Group group);

    //修改分组
    int updateGroup(Group group);

    //删除分组
    int deleteGroup(Group group);

    List<TestPaper> queryTestPaper(String acc);

    //添加试卷
    int insertTestPaper(TestPaper testPaper);

    //对应试卷中添加试题
    int insertTestPaperQuestion(TestQuestion testQuestion);

    //查询对应试卷下的的所有试题
    List<Question> queryTestQuestion(String acc, String id);

    //删除试卷
    int deleteTestPaper(TestPaper testPaper);

    //删除对应试卷下的试题
    int deleteTestQuestion(Question question);

    //添加试卷生成后的路径
    int addTestUrl(TestPaper testPaper);

    //分页查询试题
    List<Question> queryQuestionAll(Question question);
}
