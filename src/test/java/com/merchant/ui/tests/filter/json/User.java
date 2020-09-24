package com.merchant.ui.tests.filter.json;

import java.util.Date;

public class User {
	private String userName;
	private String email;
	private String password;
	private Date generatedAt;
	
	public User(String userName, String email, String password, Date generatedAt) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.generatedAt = generatedAt;
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(Date generatedAt) {
		this.generatedAt = generatedAt;
	}
	
	
	
	
}
