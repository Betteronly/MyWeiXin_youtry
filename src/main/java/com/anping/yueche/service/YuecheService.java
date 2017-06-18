package com.anping.yueche.service;

import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.ServiceTelCallHistory;
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

    /**
     * 拨打客服电话 记录
     *
     * @return
     */
    public int saveServiceTelCall(ServiceTelCallHistory serviceTelCallHistory);

    /**
     * 拨打客服电话 获取记录数
     * @param serviceTelCallHistory
     * @return
     */
    public String getServiceTelCallCount(ServiceTelCallHistory serviceTelCallHistory);
}
