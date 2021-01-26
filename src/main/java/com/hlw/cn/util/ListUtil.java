package com.hlw.cn.util;

import com.hlw.cn.pojo.ExamAnswer;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListUtil  implements  Serializable{
    public static List<ExamAnswer> list;

    public ListUtil(){}
    public List<ExamAnswer> getList() {
        return list;
    }

    public void setList(List<ExamAnswer> list) {
        this.list = list;
    }


}
