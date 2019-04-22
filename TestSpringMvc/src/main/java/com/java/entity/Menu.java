package com.java.entity;

import java.util.Date;

public class Menu {
	
	private Integer id;//菜单id
	private String name;//菜单名称
	private String parentName;//父节点名称
	private long parentId;//父节点id
	private String url;//url
	private int disployOrder;//排序
	private String memo;//描述
	private int hasLeaf;//是否含有子节点
	private long creater;//创建人
	private Date createTime;//创建时间
	private long updater;//修改人
	private Date updateTime;//修改时间
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
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
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getDisployOrder() {
		return disployOrder;
	}
	public void setDisployOrder(int disployOrder) {
		this.disployOrder = disployOrder;
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
	
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public long getCreater() {
		return creater;
	}
	public void setCreater(long creater) {
		this.creater = creater;
	}
	public long getUpdater() {
		return updater;
	}
	public void setUpdater(long updater) {
		this.updater = updater;
	}
	public void setCreater(Integer creater) {
		this.creater = creater;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public void setUpdater(int updater) {
		this.updater = updater;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	

}
