package com.anping.yueche.service;

import java.util.List;

import com.betteronly.teachtools.entity.GradeAndClass;
import com.betteronly.teachtools.entity.HomeWorks;

public interface TeachToolsService {

    public String getSchoolsAll();

    public List<GradeAndClass> getGradeAndClasses(String schoolId);

    public List<String> getHaveHomeWorkDays(String schoolId, String gradeId, String classId);

    public HomeWorks getHomeWorks(String schoolId, String gradeId, String classId, String homeWorkDate);

    public List<HomeWorks> getAllHomeWorks(String schoolId, String gradeId, String classId);
}
