package com.revature.FoolLickerBar.models;

public class Bartender extends Account{
	
	private String codeName;
	private String userName;
	private String password;
	
	public Bartender(String codeName, String userName, String password) {
		super(codeName, userName, password);
		this.codeName = codeName;
		this.userName = userName;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
