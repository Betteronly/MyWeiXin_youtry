package com.anping.yueche.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.anping.yueche.pojo.CodeDic;

/**
 * 字典列表
 * 
 * @author Better
 *
 */
@MapperScan
public interface CodeDicDao {
    /*
     * 查询字典列表
     */
    public List<CodeDic> getCodeDicList(String codeId);
}