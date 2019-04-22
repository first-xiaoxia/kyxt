package com.java.entity;

public class LoginModel {
	/**
	 * 账号
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 角色Id
	 */
	private int userType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	

}
