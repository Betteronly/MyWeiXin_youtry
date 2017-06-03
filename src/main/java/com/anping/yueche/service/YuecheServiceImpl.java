package com.anping.yueche.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anping.yueche.dao.UserInfoDao;
import com.anping.yueche.pojo.UserInfo;

@Service
public class YuecheServiceImpl implements YuecheService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfo(String openId) {
        UserInfo userInfo = null;
        if (openId != null) {
            userInfo = userInfoDao.getUserInfo(openId);
        }
        return userInfo;
    }

    @Override
    public String saveUserInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String doOrderCar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String selectOrderCarRec() {
        // TODO Auto-generated method stub
        return null;
    }

}
