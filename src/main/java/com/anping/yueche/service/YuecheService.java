package com.anping.yueche.service;

import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.UserInfo;

import java.util.List;

public interface YuecheService {

    /**
     * 获取用户信息
     * 
     * @return
     */
    public UserInfo getUserInfo(String openId);

    /**
     * 保存用户信息
     * 
     * @return
     */
    public int saveUserInfo(UserInfo userInfo);

    /**
     * 编辑更新用户信息
     *
     * @return
     */
    public int editUserInfo(UserInfo userInfo);

    /**
     * 约车
     * 
     * @param carOrderInfo
     * @return
     */
    public boolean doOrderCar(CarOrderInfo carOrderInfo);

    /**
     * 查询约车记录
     * 
     * @return
     */
    public List<CarOrderInfo> getCarOrderInfo(CarOrderInfo carOrderInfo);

    /**
     * 保存约车信息
     *
     * @return
     */
    public int saveCarOrderInfo(CarOrderInfo carOrderInfo);

    /**
     * 编辑约车信息
     *
     * @return
     */
    public int editCarOrderInfo(CarOrderInfo carOrderInfo);
}
