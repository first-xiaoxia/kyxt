package com.java.entity;

public class User {
    private Integer id;
    private String yhmc;
    private String yhxb;
    private String sfzhm;

    private String userName;

    private String password;

    private int userType;
    private String jslb;

    public String getJslb() {
        return jslb;
    }

    public void setJslb(String jslb) {
        this.jslb = jslb;
    }

    public String getYhmc() {
        return yhmc;
    }

    public void setYhmc(String yhmc) {
        this.yhmc = yhmc;
    }

    public String getYhxb() {
        return yhxb;
    }

    public void setYhxb(String yhxb) {
        this.yhxb = yhxb;
    }

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    
}