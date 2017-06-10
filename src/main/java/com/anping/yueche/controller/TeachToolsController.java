package com.anping.yueche.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anping.yueche.entity.GradeAndClass;
import com.anping.yueche.entity.HomeWork;
import com.anping.yueche.entity.HomeWorks;
import com.anping.yueche.service.TeachToolsService;

@Controller
@RequestMapping("/teachtools/*")
public class TeachToolsController {

    @Autowired
    TeachToolsService teachToolsService;

    // @Autowired
    // HomeWorks homeWorks;

    public TeachToolsController() {
        super();
    }

    @RequestMapping(value = "/schools", method = RequestMethod.GET)
    public String schools(Model model) {
        String schoolId = "huoying";
        List<GradeAndClass> allGradeAndClasses = teachToolsService.getGradeAndClasses(schoolId);

        model.addAttribute("allGradeAndClasses", allGradeAndClasses);
        return "teachtools/schools";
    }

    @RequestMapping(value = "/havehomeworkdays", method = RequestMethod.POST)
    public String haveHomeWorkDays(HttpServletRequest request, String selectedSchoolId, Model model) {
        String schoolId0 = selectedSchoolId; // 参数传入方式
        String schoolId = request.getParameter("selectedSchoolId"); // 获取参数方式
        String gradeId = request.getParameter("selectedGradeId"); // 获取参数方式
        String gradeClassId = request.getParameter("selectedGradeClassId");

        List<String> listHaveHomeWorkDays = teachToolsService.getHaveHomeWorkDays(schoolId, gradeId, gradeClassId);
        model.addAttribute("homeWorks", listHaveHomeWorkDays);
        return "teachtools/homeworks";
    }

    @RequestMapping(value = "/onedayhomeworks", method = RequestMethod.POST)
    public String homeWork(HttpServletRequest request, Model model) {
        String schoolId = request.getParameter("selectedSchoolId"); // 获取参数方式
        String gradeId = request.getParameter("selectedGradeId");
        String gradeClassId = request.getParameter("selectedGradeClassId");
        String homeWorkDate = request.getParameter("selectedHomeWorkDay");
        HomeWorks oneDayHomeWorks = teachToolsService.getHomeWorks(schoolId, gradeId, gradeClassId, homeWorkDate);
        model.addAttribute("oneDayHomeWorks", oneDayHomeWorks);
        return "teachtools/homeworks";
    }

    @RequestMapping(value = "/allhomeworks", method = RequestMethod.POST)
    public String homeWorks(HttpServletRequest request, Model model) {
        String schoolId = request.getParameter("selectedSchoolId"); // 获取参数方式
        String gradeId = request.getParameter("selectedGradeId");
        String gradeClassId = request.getParameter("selectedGradeClassId");
        // String homeWorkDate = request.getParameter("selectedHomeWorkDay");
        List<HomeWorks> allHomeWorks = teachToolsService.getAllHomeWorks(schoolId, gradeId, gradeClassId);
        model.addAttribute("allHomeWorks", allHomeWorks);
        model.addAttribute("schoolId", schoolId);
        model.addAttribute("gradeId", gradeId);
        model.addAttribute("gradeClassId", gradeClassId);
        return "teachtools/homeworks";
    }

    @RequestMapping(value = "/json/onedayhomeworkjson", method = RequestMethod.GET)
    @ResponseBody
    public Object oneDayHomeWorksJson(HttpServletRequest request, Model model) {
        HomeWorks homeWorks = new HomeWorks();
        List<HomeWork> listHomeWorks = new ArrayList<>();

        // HomeWork homeWork1 = new HomeWork();
        // homeWork1.setCourse("语文");
        // homeWork1.setDeadline("当天");
        // homeWork1.setPicPath("语文161223.jpg");
        // homeWork1.setContent("抄写生字：日，火，水");
        // homeWork1.setCompletionStatus("未完成");
        // listHomeWorks.add(homeWork1);

        // HomeWork homeWork2 = new HomeWork();
        // homeWork2.setCourse("数学");
        // homeWork2.setDeadline("当天");
        // homeWork2.setPicPath("kittens.jpg");
        // homeWork2.setContent("完成习题P113");
        // homeWork2.setCompletionStatus("未完成");
        // listHomeWorks.add(homeWork2);

        // HomeWork homeWork3 = new HomeWork();
        // homeWork3.setCourse("英语");
        // homeWork3.setDeadline("下周一");
        // homeWork3.setPicPath("kittens.jpg");
        // homeWork3.setContent("完成绘本Unit6");
        // homeWork3.setCompletionStatus("未完成");
        // listHomeWorks.add(homeWork3);

        homeWorks.setListHomeWork(listHomeWorks);

        return homeWorks;
    }
}
