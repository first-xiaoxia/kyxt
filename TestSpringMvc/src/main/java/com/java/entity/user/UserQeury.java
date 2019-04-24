package com.java.entity.user;

import com.java.entity.commons.Pagenation;

/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/17 10:16
 */
public class UserQeury extends Pagenation {
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
    private String yhmc;
    /*
    学号
     */
    private String sfzhm;
    /*
    教师类型
     */
    private String jslb;

    private String userName;

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getYhmc() {
        return yhmc;
    }

    public void setYhmc(String yhmc) {
        this.yhmc = yhmc;
    }

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

    public String getJslb() {
        return jslb;
    }

    public void setJslb(String jslb) {
        this.jslb = jslb;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
