package com.anping.yueche.service;

import com.anping.yueche.pojo.UserInfo;

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
    public String saveUserInfo();

    /**
     * 约车
     * 
     * @return
     */
    public String doOrderCar();

    /**
     * 查询约车记录
     * 
     * @return
     */
    public String selectOrderCarRec();

}
