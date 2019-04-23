package com.java.entity;

import java.util.Date;

public class OrganiseUnit {
    private Integer id;
    private String name;//机构名称
    private String parentId;//父节点ID
    private String dwbh;//单位编号
    private String dwlx;//单位类型(1:管理机构 2:院系 3:研究机构)
    private String memo;//描述
    private int hasLeaf;//是否包含子节点(0:不包含 1:包含）
    private String fzr;//负责人
    private String lxr;//联系人
    private String yjxk;//一级学科
    private String lxdh;//联系电话
    private String cz;//传真
    private String dz;//地址
    private String yb;//邮编
    private String wz;//网址
    private String cjdm;//层级代码
    private long creater;//创建人
    private Date createTime;//创建时间
    private long updater;//修改人
    private Date updateTime;//修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getDwlx() {
        return dwlx;
    }

    public void setDwlx(String dwlx) {
        this.dwlx = dwlx;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getHasLeaf() {
        return hasLeaf;
    }

    public void setHasLeaf(int hasLeaf) {
        this.hasLeaf = hasLeaf;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getYjxk() {
        return yjxk;
    }

    public void setYjxk(String yjxk) {
        this.yjxk = yjxk;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getYb() {
        return yb;
    }

    public void setYb(String yb) {
        this.yb = yb;
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }

    public String getCjdm() {
        return cjdm;
    }

    public void setCjdm(String cjdm) {
        this.cjdm = cjdm;
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
