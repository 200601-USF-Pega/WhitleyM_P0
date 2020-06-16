package com.revature.FoolLickerBar.models;

public class Guest {
	private String username;
	private String password;
	private String name;
	
	public Guest(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}
}
