package com.anping.yueche.service;


import java.util.List;

import com.anping.yueche.entity.GradeAndClass;
import com.anping.yueche.entity.HomeWorks;

public interface TeachToolsService {

    public String getSchoolsAll();

    public List<GradeAndClass> getGradeAndClasses(String schoolId);

    public List<String> getHaveHomeWorkDays(String schoolId, String gradeId, String classId);

    public HomeWorks getHomeWorks(String schoolId, String gradeId, String classId, String homeWorkDate);

    public List<HomeWorks> getAllHomeWorks(String schoolId, String gradeId, String classId);
}
