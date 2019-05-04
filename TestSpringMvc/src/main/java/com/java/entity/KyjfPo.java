package com.java.entity;

import java.io.Serializable;

/**
 * 科研经费pojo
 */
public class KyjfPo implements Serializable {
    private static final long serialVersionUID = -5901829774308525837L;
    private String jflsh;//'经费流水号',
    private String xmmc;//'项目名称',
    private String jfdj;//'经费单价',
    private String sl;//'数量',
    private String jfhj;//'经费合计',
    private String fyzl;//'费用种类',
    private String fyyt;//'费用用途',
    private String cjr;//'创建人',
    private String cjsj;//'创建时间',
    private String shzt;//'审核状态0待审批，1同意，2拒绝',
    private String spr;//'审核人',
    private String shsj;//'审核时间',
    private String shly;//'审核理由',

    public String getJflsh() {
        return jflsh;
    }

    public void setJflsh(String jflsh) {
        this.jflsh = jflsh;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getJfdj() {
        return jfdj;
    }

    public void setJfdj(String jfdj) {
        this.jfdj = jfdj;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getJfhj() {
        return jfhj;
    }

    public void setJfhj(String jfhj) {
        this.jfhj = jfhj;
    }

    public String getFyzl() {
        return fyzl;
    }

    public void setFyzl(String fyzl) {
        this.fyzl = fyzl;
    }

    public String getFyyt() {
        return fyyt;
    }

    public void setFyyt(String fyyt) {
        this.fyyt = fyyt;
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
}
