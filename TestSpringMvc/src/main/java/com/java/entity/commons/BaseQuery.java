package com.java.entity.commons;

/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/17 10:16
 */
public class BaseQuery extends Pagenation {
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
    /**
     * 账号
     */
    private String userName;
    /**
     * 项目名称
     */
    private String xmmc;
    /**
     * 负责人
     */
    private String fzr;

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

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }
}
