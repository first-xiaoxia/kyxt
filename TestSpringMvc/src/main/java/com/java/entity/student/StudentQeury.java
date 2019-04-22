package com.java.entity.student;

import com.java.entity.commons.Pagenation;

/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/17 10:16
 */
public class StudentQeury extends Pagenation {
    /*
    开始日期
     */
    private String starDate;
    /*
    结束日期
     */
    private String endDate;
    /*
    姓名
     */
    private String name;
    /*
    学号
     */
    private Long studentId;
    /*
    班级
     */
    private String sclass;

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }
}
