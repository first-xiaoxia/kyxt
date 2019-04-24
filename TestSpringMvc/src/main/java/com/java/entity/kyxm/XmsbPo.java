package com.java.entity.kyxm;

import java.io.Serializable;
import java.util.Date;

public class XmsbPo implements Serializable {
    private static final long serialVersionUID = 4302857762129866534L;

    private String xmlsh;
    private String xmmc;
    private String xmxz;
    private String fzr;
    private String xkfl;
    private Date kssj;
    private Date jhwcsj;
    private String xmcyry;
    private Date cjsj;
    private String skssj;
    private String sjhwcsj;

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

    public String getXmxz() {
        return xmxz;
    }

    public void setXmxz(String xmxz) {
        this.xmxz = xmxz;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getXkfl() {
        return xkfl;
    }

    public void setXkfl(String xkfl) {
        this.xkfl = xkfl;
    }

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getJhwcsj() {
        return jhwcsj;
    }

    public void setJhwcsj(Date jhwcsj) {
        this.jhwcsj = jhwcsj;
    }

    public String getXmcyry() {
        return xmcyry;
    }

    public void setXmcyry(String xmcyry) {
        this.xmcyry = xmcyry;
    }
}
