package com.revature.FoolLickerBar.services;
import java.sql.*;
import java.util.Scanner;

import com.revature.FoolLickerBar.dao.GuestRepoDB;
import com.revature.FoolLickerBar.dao.IAlcoholStockDB;
import com.revature.FoolLickerBar.models.Account;
import com.revature.FoolLickerBar.models.Stock;
import com.revature.FoolLickerBar.*;

public class GuestService {

	IAlcoholStockDB repo;
	
	public GuestService (IAlcoholStockDB repo) {
		this.repo = repo;
		//this.validation = new ValidationService();
	}
	
		public boolean createNewTab() {

			//Hero newHero;
			Scanner scan = new Scanner(System.in);
			ValidationService validationService = new ValidationService();
			ConnectionService connectionService = new ConnectionService();
			AccountService service = new AccountService((connectionService));
			String name;
			String username;
			String password;
			//Account account = new Account(name, username, password);
			boolean caseZeroLoop = true;
			//try {
			
				System.out.println("Glad to see you came in today. Before we start with the fun stuff, I need you to log in to your guest account here at Fool Licker bar.");
				System.out.println(" ");
				System.out.println("[1] Create account");
				System.out.println("[2] Log in to existing account");
				System.out.println("[3] What kind of bar has accounts? I don't trust that for one second...Seeya");
				
				String input = scan.next();
				int option = 0;
				
				try {
					option = Integer.parseInt(input);
				}
				catch(NumberFormatException optionExp){
					option=1;
					System.out.println("Hey, don't get fancy. No decimals or funny business now");
				}	
				
				switch(option) {
				case 1:
					Statement st = null;
					try {
					PreparedStatement getStock = connectionService.getConnection().prepareStatement(
								"SELECT * FROM stock;");
						ResultSet itemsRS = getStock.executeQuery();
				//	ResultSet rs = st.executeQuery("SELECT * from contacts");
					ResultSetMetaData rsmd = itemsRS.getMetaData();
					int columnsNumber = rsmd.getColumnCount();

					while (itemsRS.next()) {
					    for(int i = 1; i < columnsNumber; i++)
					        System.out.print(itemsRS.getString(i) + "    ");
					    System.out.println();
					}
					}catch (SQLException e) {
						System.out.println("Exception: " + e.getMessage());
						e.printStackTrace();
					}
					//repo.getAllItems();
					//System.out.println("Hey, don't get fancy. No decimals or funny business now");
				}
				/*
				switch(option) {
				case 1: 
					System.out.println("Hello friend. This is probably the most work you've had to do to pay somebody else money! Hahaha! Anyways...");
					System.out.println("");
					
					System.out.print("Tell us your name:  ");
					String nameValid = validationService.getValidString();
					
					System.out.print("Create a username! 5-20 characters ");
					String userNameValid = validationService.getValidString();
					while (caseZeroLoop) {
						if (userNameValid.length() > 20 || userNameValid.length() < 5) {
							System.out.println("Learn to count, try again later...");	
																		
						} else if(playerService.checkPlayerExists(inputtedID)) {
							inputtedID = validationService.getValidString();
							System.out.println("ID already taken...try again");
						} else {
							String inputtedPassword = "";
							do {
								System.out.println("Enter a password (4-24 characters):");
								inputtedPassword = validationService.getValidString();
							} while(inputtedPassword.length() < 4 || inputtedPassword.length() > 24); 					
							currPlayerID = playerService.createNewPlayer(inputtedID, inputtedPassword);
							loggedIn = true;
							break;
						}
					}
				/*	name = scan.next();
					System.out.print("Create username: ");
					username = scan.next();
					System.out.print("Create password: ");
					password = scan.next();
					
					Account caseOne = new Account(name, username, password);
					//caseOne.createNewAccount(caseOne);
					//call create account method
					break;
				case 2:
					//AccountService caseTwo = new AccountService();
					//call log in to account method
					break;
				case 3:
					System.out.println("Hey man, it's 2020. DIGITAL REVOLUTION!");
					break;
				default: 
					System.out.println("Sorry pal. You have to choose from one of the options listed above");
				}
				
				System.out.println("[1] Feeling fancy...do y'all have wine?");
				System.out.println("[2] Gimmie a beer for the game");
				System.out.println("[3] Give me your strongest stuff");
				System.out.println("[4] Sorry, man. Not feeling it after all");
				

				String typeOfAlcohol = scan.nextLine();
				
				//scan.nextLine();
				//^^scanners can be buggy so you use this to make it work
			//}
			//finally {
			//	System.out.print("smd");
		//	}
		*/
				
			return true;
}
}
