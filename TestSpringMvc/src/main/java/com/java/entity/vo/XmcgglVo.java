package com.java.entity.vo;

import java.io.Serializable;

public class XmcgglVo implements Serializable {
    private static final long serialVersionUID = -7583225874414444060L;

    private String bh;
    private String xmlsh;

    private String xmmc;

    private String cglsh;

    private String cgmc;
    private String cgjb;
    private String cgfl;

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

    public String getCgjb() {
        return cgjb;
    }

    public void setCgjb(String cgjb) {
        this.cgjb = cgjb;
    }

    public String getCgfl() {
        return cgfl;
    }

    public void setCgfl(String cgfl) {
        this.cgfl = cgfl;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }
}
