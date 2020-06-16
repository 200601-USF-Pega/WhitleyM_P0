package com.revature.FoolLickerBar.services;
import java.util.Scanner;

//import com.revature.FoolLickerBar.dao.IGuestRepo;
import com.revature.FoolLickerBar.models.Account;

public class AccountService {
	
ConnectionService connectionService;
ValidationService inputValidation = new ValidationService();
//IGuestRepo repo;

//public AccountService(IGuestRepo repo) {
	//this.repo = repo;
//}
	
	public AccountService(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	public Account createNewAccount(Account account){
		return account;
	

	
			
		
		
		
	
	}
}
