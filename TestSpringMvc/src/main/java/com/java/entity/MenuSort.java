package com.java.entity;

import java.util.List;

public class MenuSort {
	/**
	 * ID
	 */
	private long id;
	/**
	 * 名称
	 */
	private String text;
	/**
	 * url
	 */
	private String url;
	/**
	 * 是否存在子节点
	 */
	private boolean leaf;
	/**
	 * 节点状态
	 */
	private String state;
	/**
	 * 父节点名称
	 */
	private String parentName;
	/**
	 * 父节点ID
	 */
	private long parentId;
	/**
	 * 描述
	 */
	private String memo;
	/**
	 * 显示顺序
	 */
	private int disployOrder;//显示顺序
	/**
	 * 子节点集合
	 */
	private List<MenuSort> children;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getDisployOrder() {
		return disployOrder;
	}
	public void setDisployOrder(int disployOrder) {
		this.disployOrder = disployOrder;
	}
	public List<MenuSort> getChildren() {
		return children;
	}
	public void setChildren(List<MenuSort> children) {
		this.children = children;
	}
	
}
