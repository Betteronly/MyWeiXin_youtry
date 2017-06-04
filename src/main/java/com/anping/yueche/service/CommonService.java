package com.anping.yueche.service;

import java.util.List;

import com.anping.yueche.entity.CodeItem;
import com.anping.yueche.pojo.CodeDic;

public interface CommonService {

    /**
     * 获取字典列表：key，value
     * 
     * @return
     */
    public List<CodeItem> getCodeItemList(String codeId);

    /**
     * 获取字典列表：all
     * 
     * @return
     */
    public List<CodeDic> getCodeDicList(String codeId);

}
