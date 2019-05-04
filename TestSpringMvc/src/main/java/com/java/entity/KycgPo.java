package com.java.entity;

import java.io.Serializable;

/**
 * 项目成功对象
 */
public class KycgPo implements Serializable {

    private static final long serialVersionUID = 7347873498010048936L;
    private String cglsh;//科研成果流水号'
    private String cgmc;//成果名称'
    private String cgjb;//成果分类'
    private String cgfl;//成果分类'
    private String ckwz;//'查看网站'
    private String wjlshs;// '文件流水号集合'
    private String cjr;
    private String cjsj;//'创建时间
    private String shzt;//'审核状态0待审批，1同意，2拒绝'
    private String spr;//'审核人'
    private String shsj;//'审核时间'
    private String shly;//审核理由

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


    public String getCgfl() {
        return cgfl;
    }

    public void setCgfl(String cgfl) {
        this.cgfl = cgfl;
    }

    public String getCkwz() {
        return ckwz;
    }

    public void setCkwz(String ckwz) {
        this.ckwz = ckwz;
    }

    public String getWjlshs() {
        return wjlshs;
    }

    public void setWjlshs(String wjlshs) {
        this.wjlshs = wjlshs;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt;
    }

    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    public String getShsj() {
        return shsj;
    }

    public void setShsj(String shsj) {
        this.shsj = shsj;
    }

    public String getShly() {
        return shly;
    }

    public void setShly(String shly) {
        this.shly = shly;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }

    public String getCgjb() {
        return cgjb;
    }

    public void setCgjb(String cgjb) {
        this.cgjb = cgjb;
    }
}
