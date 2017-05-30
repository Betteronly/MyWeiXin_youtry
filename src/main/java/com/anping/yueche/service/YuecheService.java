package com.anping.yueche.service;

import java.util.List;

import com.anping.yueche.entity.GradeAndClass;
import com.anping.yueche.entity.HomeWorks;
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

    public String getSchoolsAll();

    public List<GradeAndClass> getGradeAndClasses(String schoolId);

    public List<String> getHaveHomeWorkDays(String schoolId, String gradeId, String classId);

    public HomeWorks getHomeWorks(String schoolId, String gradeId, String classId, String homeWorkDate);

    public List<HomeWorks> getAllHomeWorks(String schoolId, String gradeId, String classId);
}
