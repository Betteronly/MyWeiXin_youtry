package com.anping.yueche.service;

import com.anping.yueche.dao.CarOrderInfoDao;
import com.anping.yueche.dao.UserInfoDao;
import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YuecheServiceImpl implements YuecheService {
    private static Logger log = LoggerFactory.getLogger(YuecheServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private CarOrderInfoDao carOrderInfoDao;

    @Override
    public UserInfo getUserInfo(String openId) {
        UserInfo userInfoParam = new UserInfo();
        if (openId != null) {
            userInfoParam.setOpenId(openId);
            List<UserInfo> userInfoList = userInfoDao.selectUserInfo(userInfoParam);
            if (userInfoList != null && userInfoList.size() > 0){
                userInfoParam = userInfoList.get(0);
            }
        }

        return userInfoParam;
    }

    @Override
    public int saveUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public int editUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
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
    public List<CarOrderInfo> getCarOrderInfo(CarOrderInfo carOrderInfo) {
        return carOrderInfoDao.selectCarOrderInfo(carOrderInfo);
    }

    @Override
    public int saveCarOrderInfo(CarOrderInfo carOrderInfo){
        return carOrderInfoDao.insertCarOrderInfo(carOrderInfo);
    }

    @Override
    public int editCarOrderInfo(CarOrderInfo carOrderInfo){
        return carOrderInfoDao.updateCarOrderInfo(carOrderInfo);
    }
}
