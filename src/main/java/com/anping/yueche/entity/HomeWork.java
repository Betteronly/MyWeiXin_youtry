package com.anping.yueche.entity;

/**
 * 家庭作业
 * 
 * @author Better
 *
 */
public class HomeWork {
    // 课程
    private String course;
    // 完成期限
    private String deadline;
    // 附图路径
    private String picPath;
    // 作业内容
    private String content;
    // 完成情况
    private String completionStatus;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }
}
