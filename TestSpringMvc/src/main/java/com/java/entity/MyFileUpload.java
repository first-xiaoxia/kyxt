package com.java.entity;

import java.io.Serializable;

/**
 * 项目成功对象
 */
public class MyFileUpload implements Serializable {
    /**
     * 文件流水号
     */
    private String wjlsh;
    /**
     * 文件名称
     */
    private String wjmc;
    /**
     * 文件路径
     */
    private String wjlj;

    private String cglsh;

    private String cgmc;
    /**
     * 后缀名
     */
    private String hzm;
    /**
     * 文件类型0图片，1音频，2视频，3文件
     */
    private String wjlx;

    public String getWjlsh() {
        return wjlsh;
    }

    public void setWjlsh(String wjlsh) {
        this.wjlsh = wjlsh;
    }

    public String getWjmc() {
        return wjmc;
    }

    public void setWjmc(String wjmc) {
        this.wjmc = wjmc;
    }

    public String getWjlj() {
        return wjlj;
    }

    public void setWjlj(String wjlj) {
        this.wjlj = wjlj;
    }

    public String getHzm() {
        return hzm;
    }

    public void setHzm(String hzm) {
        this.hzm = hzm;
    }

    public String getWjlx() {
        return wjlx;
    }

    public void setWjlx(String wjlx) {
        this.wjlx = wjlx;
    }

    public String getCglsh() {
        return cglsh;
    }

    public void setCglsh(String cglsh) {
        this.cglsh = cglsh;
    }

    public String getCgmc() {
        return cgmc;
    }

    public void setCgmc(String cgmc) {
        this.cgmc = cgmc;
    }
}
