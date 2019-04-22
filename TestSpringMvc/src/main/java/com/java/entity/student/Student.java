package com.java.entity.student;

import java.util.Date;

/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/16 18:01
 */
public class Student {
    /*
    id
     */
    private Long id;
    /*
    姓名
     */
    private String name;
    /*
    班级
     */
    private String sclass;
    /*
    学号
     */
    private Long StudentId;
    /*
    年龄
     */
    private long age;
    /*
    身高
     */
    private String height;
    /*
    体重
     */
    private String weight;
    /*
    创建人
     */
    private long creater;
    /*
    创建时间
     */
    private Date createTime;
    /*
    修改人
     */
    private long updater;
    /*
    修改时间
     */
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long studentId) {
        StudentId = studentId;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public long getCreater() {
        return creater;
    }

    public void setCreater(long creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getUpdater() {
        return updater;
    }

    public void setUpdater(long updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
