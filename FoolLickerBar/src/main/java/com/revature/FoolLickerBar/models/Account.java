package com.revature.FoolLickerBar.models;

public class Account {
	
	private String username;
	private String password;
	private String name;
	
	public Account(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username.isEmpty()) throw new IllegalArgumentException();
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password.isEmpty()) throw new IllegalArgumentException();
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.isEmpty()) throw new IllegalArgumentException();
		this.name = name;
	}
	
	
}
