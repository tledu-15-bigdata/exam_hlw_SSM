package com.hlw.cn.pojo;

public class TestPaper {

    //试卷id
    private String testId;
    //试卷分组
    private String testGroup;
    //试卷标题
    private String testTitle;
    //创建时间
    private String testCreatetime;
    //是否存在  1存在  0不存在
    private String testIsdelete;
    //试卷生成的路径
    private String testUrl ;
    //与用户账号绑定
    private String testAcc;

    public TestPaper() {
    }

    public TestPaper(String testId, String testGroup, String testTitle, String testCreatetime, String testIsdelete, String testUrl, String testAcc) {
        this.testId = testId;
        this.testGroup = testGroup;
        this.testTitle = testTitle;
        this.testCreatetime = testCreatetime;
        this.testIsdelete = testIsdelete;
        this.testUrl = testUrl;
        this.testAcc = testAcc;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestGroup() {
        return testGroup;
    }

    public void setTestGroup(String testGroup) {
        this.testGroup = testGroup;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String getTestCreatetime() {
        return testCreatetime;
    }

    public void setTestCreatetime(String testCreatetime) {
        this.testCreatetime = testCreatetime;
    }

    public String getTestIsdelete() {
        return testIsdelete;
    }

    public void setTestIsdelete(String testIsdelete) {
        this.testIsdelete = testIsdelete;
    }

    public String getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl;
    }

    public String getTestAcc() {
        return testAcc;
    }

    public void setTestAcc(String testAcc) {
        this.testAcc = testAcc;
    }

    @Override
    public String toString() {
        return "TestPaper{" +
                "testId='" + testId + '\'' +
                ", testGroup='" + testGroup + '\'' +
                ", testTitle='" + testTitle + '\'' +
                ", testCreatetime='" + testCreatetime + '\'' +
                ", testIsdelete='" + testIsdelete + '\'' +
                ", testUrl='" + testUrl + '\'' +
                ", testAcc='" + testAcc + '\'' +
                '}';
    }
}
