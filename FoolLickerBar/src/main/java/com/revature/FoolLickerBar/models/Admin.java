package com.revature.FoolLickerBar.models;

public class Admin extends Account{

	private String codeName;
	private String userName;
	private String adminPassword;
	
	public Admin(String codeName, String userName, String adminPassword) {
		super(codeName, userName, adminPassword);
		this.codeName = codeName;
		this.userName = userName;
		this.adminPassword = adminPassword;
	}
	
	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
