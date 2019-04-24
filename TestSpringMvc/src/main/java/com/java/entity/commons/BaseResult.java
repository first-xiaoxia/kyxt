package com.java.entity.commons;

import java.util.List;

public class BaseResult<T> {
	
	/**
	 * 数据行
	 */
	private List<T> rows;
	/**
	 * 总记录条
	 */
	private int total;

	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
