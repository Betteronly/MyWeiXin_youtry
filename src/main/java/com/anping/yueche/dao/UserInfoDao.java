package com.anping.yueche.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.anping.yueche.pojo.UserInfo;

/**
 * 用户信息
 * 
 * @author Better
 *
 */
@MapperScan
public interface UserInfoDao {
    public UserInfo selectUserInfo(String openId);

    public boolean insertUserInfo(UserInfo userInfo);

    public boolean updateUserInfo(UserInfo userInfo);
}