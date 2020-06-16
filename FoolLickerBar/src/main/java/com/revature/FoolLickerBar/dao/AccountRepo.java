package com.revature.FoolLickerBar.dao;

import java.sql.*;

import com.revature.FoolLickerBar.models.Account;
import com.revature.FoolLickerBar.models.Guest;
import com.revature.FoolLickerBar.services.ConnectionService;

public class AccountRepo{ //implements IAccountRepo {
	//use the sql commands to make it so username, password, and name are logged onto the table
	ConnectionService connectionService;
	
	public AccountRepo(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	/*
	public Account addAccount(Guest guest, String name, String username, String password) {
		// TODO Auto-generated method stub
		try {			
			PreparedStatement guestInsert = connectionService.getConnection().prepareStatement(
					"INSERT INTO guests VALUES (?, ?, ?)");
			guestInsert.setString(1, name);
			guestInsert.setString(2, username);
			guestInsert.setString(3, password);
			guestInsert.execute();
			
			return guest;
			
	}
		catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	*/
	

}
