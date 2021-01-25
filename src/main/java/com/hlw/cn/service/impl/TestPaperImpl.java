package com.hlw.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hlw.cn.dao.QuestionBankDao;
import com.hlw.cn.dao.TestPaperDao;
import com.hlw.cn.pojo.*;
import com.hlw.cn.service.TestPaperService;
import com.hlw.cn.util.PageUtils;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TestPaperImpl implements TestPaperService {

    @Autowired
    private TestPaperDao testPaperDao;
    @Autowired
    private QuestionBankDao questionBankDao;

    //查询分组
    @Override
    public PageUtils queryGroup(Map<String,Object> param) {

        PageHelper.offsetPage(Integer.parseInt(param.get("offset").toString()),Integer.parseInt(param.get("pageNumber").toString()));
        //接收数据库数据
        List<Group> list=null;
        if (param.get("acc").toString()!=null){
            list= testPaperDao.queryGroupALl(param.get("acc").toString());
            System.out.println(list);//////////
        }

        PageInfo<Group> pageInfo=new PageInfo<Group>(list);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }

    //添加分组
    @Override
    public boolean addGroup(Group group) {

        System.out.println(group);///////////
        //查询该分组是否存在，若存在不允许添加
        int groupNum=testPaperDao.queryGroup(group);
        if (groupNum==0){
            //   新增分组
            group.setGroupId(UUID.randomUUID().toString());

            System.out.println(group);//////////

            //返回受影响行数
            int i=testPaperDao.insertGroup(group);
            if(i!=0)return true;
        }
        return false;

    }

    //修改分组
    @Override
    public boolean updateGroup(Group group){
        boolean flag=false;

        System.out.println(group);
        if (testPaperDao.updateGroup(group)==1){
            flag = true;
        }
        return flag;
    }

    //删除分组
    @Override
    public boolean deleteGroup(Group group){
        boolean flag=false;

        if (testPaperDao.deleteGroup(group)==1){
            flag = true;
        }
        return flag;
    }

    //添加试卷
    @Override
    public Map<String,Object> addTestPaper(TestPaper testPaper) {

        Map<String,Object> params = new HashMap<String,Object>();

        System.out.println(testPaper);///////////
        //随机产生id
        String uuid = UUID.randomUUID().toString();
        testPaper.setTestId(uuid);
        System.out.println(testPaper);///////////
        if (testPaperDao.insertTestPaper(testPaper)==1){
            params.put("mark",true);//mark:是否添加成功
            params.put("testId",uuid);//testId：试卷的id
        }else {
            params.put("mark",false);
            params.put("testId",null);
        }
        return params;
    }

    //查询所有的试卷信息
    @Override
    public PageUtils queryTestPaper(Map<String,Object> param) {

        PageHelper.offsetPage(Integer.parseInt(param.get("offset").toString()),Integer.parseInt(param.get("pageNumber").toString()));
        //接收数据库数据
        List<TestPaper> list=null;
        if (param.get("acc").toString()!=null){
            list= testPaperDao.queryTestPaper(param.get("acc").toString());
            System.out.println(list);//////////
        }

        PageInfo<TestPaper> pageInfo=new PageInfo<TestPaper>(list);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }


    //返回题库中的试题数据  分页
    @Override
    public PageUtils queryTestPaperQuestion(Map<String,Object> param) {

        PageHelper.offsetPage(Integer.parseInt(param.get("offset").toString()),Integer.parseInt(param.get("pageNumber").toString()));
        //接收数据库数据
        List<Question> list1=null;
        List<Question> list2=null;
        if (param.get("acc").toString()!=null){
            //从题库中拿到所有的题
            list1 = testPaperDao.queryQuestionAll(new Question(param.get("subject").toString(),param.get("acc").toString(),(int)param.get("select")));
            System.out.println("过滤前"+list1.toString());////////////
            //拿到对应试卷下的的所有试题
            list2 = testPaperDao.queryTestQuestion(param.get("acc").toString(),param.get("id").toString());
            //遍历删除试卷中已经存在的试题
            for (int i=0;i<list2.size();i++){
                for (int j=0;j<list1.size();j++){
                    if (list2.get(i).getQuestionId().equals(list1.get(j).getQuestionId())){
                        list1.remove(j);
                    }
                }
            }
            System.out.println("过滤后"+list1.toString());//////////
        }

        PageInfo<Question> pageInfo=new PageInfo<Question>(list1);
        return new PageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }

    //对应试卷中添加试题
    @Override
    public boolean addTestPaperQuestion(SelectQuestion selectQuestion){
        int num = 0;
        System.out.println(selectQuestion);
        for (int i=0;i<selectQuestion.getUlist().size();i++){
            Question q = questionBankDao.queryQuestionOne1(selectQuestion.getUlist().get(i));
            System.out.println(q);
            if (testPaperDao.insertTestPaperQuestion(new TestQuestion(q.getQuestionId(),q.getQuestionTopic(),q.getQuestionScore(),q.getQuestionAnswer(),q.getQuestionClassify(),q.getQuestionAcc(),q.getQuestionCreatetime(),q.getQuestionIsdelete(),q.getQuestionType(),q.getSingleA(),q.getSingleB(),q.getSingleC(),q.getSingleD(),selectQuestion.getQuestionId()))==1){
                num++;
            }
        }
        if (num==selectQuestion.getUlist().size()) return true;

        return false;
    }

    //返回对应试卷中的试题数据  返回map
    @Override
    public Map<String,Object> queryTestQuestion(TestPaper testPaper){
        Map<String,Object> params = new HashMap<String,Object>();
        List<Question> list=null;

        if (testPaper.getTestAcc()!=null && testPaper.getTestId()!=null){
            list = testPaperDao.queryTestQuestion(testPaper.getTestAcc(),testPaper.getTestId());
            //遍历将abcd答案数据添加进试题中
            for (Question q:list){
                if (q.getQuestionType()==0){
                    Question qtemp=questionBankDao.queryQuestionOne2(q.getQuestionId());
                    q.setSingleA(qtemp.getSingleA());
                    q.setSingleB(qtemp.getSingleB());
                    q.setSingleC(qtemp.getSingleC());
                    q.setSingleD(qtemp.getSingleD());
                }
            }
            params.put("list",list);
            params.put("length",list.size());
        }
        return params;
    }

    //删除试卷
    @Override
    public boolean deleteTestPaper(TestPaper testPaper){
        boolean flag=false;


        if (testPaperDao.deleteTestPaper(testPaper)==1){
            flag = true;
        }
        return flag;
    }

    //删除对应试卷下的试题
    @Override
    public boolean deleteTestQuestion(Question question){
        boolean flag=false;
        System.out.println(question);
        if (testPaperDao.deleteTestQuestion(question)==1){
            flag = true;
        }
        return flag;
    }

    //添加试卷生成后的路径
    @Override
    public boolean addTestUrl(TestPaper testPaper){
        boolean flag=false;

        if (testPaperDao.addTestUrl(testPaper)==1){
            flag = true;
        }
        return flag;
    }
}
