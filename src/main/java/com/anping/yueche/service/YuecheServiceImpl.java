package com.anping.yueche.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anping.yueche.dao.CarOrderInfoDao;
import com.anping.yueche.dao.UserInfoDao;
import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.UserInfo;

@Service
public class YuecheServiceImpl implements YuecheService {
    private static Logger log = LoggerFactory.getLogger(YuecheServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private CarOrderInfoDao carOrderInfoDao;

    @Override
    public UserInfo getUserInfo(String openId) {
        UserInfo userInfo = null;
        if (openId != null) {
            userInfo = userInfoDao.selectUserInfo(openId);
        }
        return userInfo;
    }

    @Override
    public int saveUserInfo() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean doOrderCar(CarOrderInfo carOrderInfo) {
        // TODO Auto-generated method stub
        boolean ret = false;
        try {
            int insertCount = carOrderInfoDao.insertCarOrderInfo(carOrderInfo);
            if (insertCount == 1) {
                ret = true;
            }
        } catch (Exception e) {
            log.info("约车信息插入处理失败！" + e);
        }
        return ret;
    }

    @Override
    public String selectOrderCarRec() {
        // TODO Auto-generated method stub
        return null;
    }

}
