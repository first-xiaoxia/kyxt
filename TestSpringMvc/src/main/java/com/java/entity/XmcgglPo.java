package com.java.entity;

import java.io.Serializable;

/**
 * 项目成果关联对象
 */
public class XmcgglPo implements Serializable {
    private static final long serialVersionUID = 615258963343664905L;
    /**
     *编号
     */
    private String bh;
    /**
     *标准名称
     */
    private String xmlsh;
    /**
     *分值
     */
    private String xmmc;
    /**
     *单位
     */
    private String cglsh;
    /**
     *创建人
     */
    private String cgmc;


    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getXmlsh() {
        return xmlsh;
    }

    public void setXmlsh(String xmlsh) {
        this.xmlsh = xmlsh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
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
