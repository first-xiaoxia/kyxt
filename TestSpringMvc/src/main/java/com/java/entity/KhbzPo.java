package com.java.entity;

import java.io.Serializable;

/**
 * 考核标准对象
 */
public class KhbzPo implements Serializable {
    private static final long serialVersionUID = 1494524468472875624L;
    /**
     *编号
     */
    private String bzlsh;
    /**
     *标准名称
     */
    private String bzmc;
    /**
     *分值
     */
    private String fz;
    /**
     *单位
     */
    private String dw;
    /**
     *创建人
     */
    private String cjr;
    /**
     *创建时间
     */
    private String cjsj;


    public String getBzlsh() {
        return bzlsh;
    }

    public void setBzlsh(String bzlsh) {
        this.bzlsh = bzlsh;
    }

    public String getBzmc() {
        return bzmc;
    }

    public void setBzmc(String bzmc) {
        this.bzmc = bzmc;
    }

    public String getFz() {
        return fz;
    }

    public void setFz(String fz) {
        this.fz = fz;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }
}
