package com.anping.yueche.entity;

/**
 * 家庭作业
 *
 * @author Better
 *
 */
public class GradeAndClass {
    // 学校
    private String schoolId;
    private String school;
    // 年级
    private String gradeId;
    private String grade;
    // 班级
    private String gradeClassId;
    private String gradeClass;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeClassId() {
        return gradeClassId;
    }

    public void setGradeClassId(String gradeClassId) {
        this.gradeClassId = gradeClassId;
    }

    public String getGradeClass() {
        return gradeClass;
    }

    public void setGradeClass(String gradeClass) {
        this.gradeClass = gradeClass;
    }
}
