package com.ui.pojo;

public class Users {
	
	private String emailAddress; 
	private String password;
	private String userName;
	
	public Users(String emailAddress, String password,String userName) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [emailAddress=" + emailAddress + ", password=" + password + ", userName=" + userName + "]";
	}

	
}
