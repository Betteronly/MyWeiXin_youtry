package com.anping.yueche.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anping.yueche.dao.CodeDicDao;
import com.anping.yueche.entity.CodeItem;
import com.anping.yueche.pojo.CodeDic;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CodeDicDao codeDicDao;

    @Override
    public List<CodeItem> getCodeItemList(String codeId) {
        List<CodeItem> codeItemList = new ArrayList();

        List<CodeDic> codeDicList = codeDicDao.getCodeDicList(codeId);

        if (codeDicList != null) {
            for (CodeDic codeDic : codeDicList) {
                CodeItem codeItem = new CodeItem();
                codeItem.setKey(codeDic.getKey());
                codeItem.setValue(codeDic.getValue());
                codeItemList.add(codeItem);
            }
        }
        return codeItemList;
    }

    @Override
    public List<CodeDic> getCodeDicList(String codeId) {
        return codeDicDao.getCodeDicList(codeId);
    }
}
