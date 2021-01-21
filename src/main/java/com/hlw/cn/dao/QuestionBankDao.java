package com.hlw.cn.dao;

import com.hlw.cn.pojo.Classify;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Daipeng
 */
@Mapper
public interface QuestionBankDao {

    public int insertClassify(Classify classify);
}
