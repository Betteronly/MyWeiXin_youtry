package com.anping.yueche.dao;

import com.anping.yueche.pojo.UserInfo;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 用户信息
 * 
 * @author Better
 *
 */
@MapperScan
public interface UserInfoDao {
    public List<UserInfo> selectUserInfo(UserInfo userInfo);

    public int insertUserInfo(UserInfo userInfo);

    public int updateUserInfo(UserInfo userInfo);
}