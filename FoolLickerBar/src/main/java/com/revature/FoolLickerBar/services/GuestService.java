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
			boolean loop = true;
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
					System.out.println("Glad to see a newcomer! What's your first name?");
					//name = scan.next();
					String nameValid = scan.next();//validationService.getValidString(); //takes in name
					System.out.print("Create a username! 5-15 characters ");
					//String userNameValid = validationService.getValidString(); //takes in username
					String userNameValid = scan.next();
					
					//while (caseZeroLoop) {
						if (userNameValid.length() > 15 || userNameValid.length() < 5) {
							System.out.println("Innapropriate username length!");
							createNewTab();
							connectionService.finalize();
						} else if(checkGuestExists(userNameValid)) {
							userNameValid = validationService.getValidString();
							//System.out.println("ID already taken...try again");
						} else {
							System.out.print("Create a password! 5-20 characters ");
							String passwordValid = scan.next();//validationService.getValidString(); //takes in password
							if (passwordValid.length() > 20 || passwordValid.length() < 5) {
								System.out.println("Innapropriate password length!");
								connectionService.finalize();
								createNewTab();
							} //else if(checkGuestExists(userNameValid)) {
								//userNameValid = validationService.getValidString();
							else {
								try {
									PreparedStatement addGuest = connectionService.getConnection().prepareStatement(
											"INSERT INTO guests (guestusername, guestpassword, guestname) VALUES (?, ?, ?);");
									addGuest.setString(1, userNameValid);
									addGuest.setString(2, passwordValid);
									addGuest.setString(3, nameValid);
									addGuest.execute();
									System.out.println("Account created and tab opened!");
									connectionService.finalize();
									//userVerification.executeQuery();
						
									
								}catch (SQLException e) {
									System.out.println("Exception: " + e.getMessage());
									e.printStackTrace();
								}
							}
							
							
							//PreparedStatement usernameInsert = connectionService.getConnection().prepareStatement(
								//	"INSERT INTO guest_info VALUES (?)");
							//playerInsert.setString(1, player.getPlayerID());
						}
					break;
					//repo.getAllItems();
					//System.out.println("Hey, don't get fancy. No decimals or funny business now");
				case 2:
					while(loop=true) {
					System.out.print("Glad to see a regular! Enter your username: ");
					//String userNameValid = validationService.getValidString(); //takes in username
					String regularUserName = scan.next();	
					System.out.print("Please enter password: ");
					String regularPassword = scan.next();
					Statement st;
					try {
						PreparedStatement userVerification = connectionService.getConnection().prepareStatement(
							"SELECT guestusername, guestpassword, guestname FROM guests WHERE guestusername = ? AND guestpassword = ?");
						userVerification.setString(1, regularUserName);
						userVerification.setString(2, regularPassword);
						userVerification.executeQuery();
						ResultSet rs = userVerification.executeQuery();
					
						if(rs.next()) {
							System.out.println("\nLogin successful! How can I help you? \n");
							
							
						//THIS NEXT PART OF CODE IS SO UGLY I AM SORRY
							
							connectionService.finalize();
							//loop=false; <-- for some reason this does nothing to stop the while loop, so i broke out of it manually
							//connectionService.close();
							System.out.println("What all would you like to do?\n[1] Buy a drink! \n[2] I'm done for the day");
							String barInput = scan.next();
							int option2 = 0;
							try {
								option2= Integer.parseInt(barInput);
							}
							catch(NumberFormatException optionExp){
								option2=1;
								System.out.println("Hey, don't get fancy. No decimals or funny business now");
							}	
							switch(option2) {
							case 1:
								getDrinkMenu();
								break;
							case 2:
								//getGuests();
								break;
							}
						break;
						}else {
							System.out.println("\nLogin not successful. Try again \n");
						}
			
					
					}catch (SQLException e) {
						System.out.println("Exception: " + e.getMessage());
						e.printStackTrace();
					}
					}
				break;
						
				case 3:
					System.out.println("Hey man, it's 2020. DIGITAL REVOLUTION!\n\nNice try...");
					createNewTab();
					break;
				default: 
					System.out.println("Sorry pal. You have to choose from one of the options listed above");
				
				}
				
			return true;
}
		
		public boolean checkGuestExists(String valid){
			//List<Guest> guestsThatExist = repo.getAllPlayers();
			ConnectionService connectionService = new ConnectionService();
			try {
				PreparedStatement userVerification = connectionService.getConnection().prepareStatement(
						"SELECT guestusername FROM guests WHERE guestusername = ?");
				userVerification.setString(1, valid);

				//userVerification.executeQuery();
				ResultSet rs = userVerification.executeQuery();
			
				if(!rs.next()) { //if username is NOT already taken...
					System.out.println("Accepted! \n");
					connectionService.finalize();
				}else {
					System.out.println("\nUsername already taken. Try again \n");
					connectionService.finalize();
					createNewTab();
				}
	
				
			}catch (SQLException e) {
				System.out.println("Exception: " + e.getMessage());
				e.printStackTrace();
			}
			return false;
			}
		
		public int getDrinkMenu(){
			ConnectionService connectionService = new ConnectionService();
			Statement st= null;
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Of course! Here is today's drink menu:\n");
			
			try {
				PreparedStatement getStock = connectionService.getConnection().prepareStatement(
							"SELECT * FROM stock;");
					ResultSet itemsRS = getStock.executeQuery();
			//	ResultSet rs = st.executeQuery("SELECT * from contacts");
				ResultSetMetaData rsmd = itemsRS.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				System.out.println(String.format("|%-20s|%-20s|%-20s|%-20s", "Alcohol Type", 
						"Alcohol Name", "Alcohol Content (%)", "Price\n"));
				while (itemsRS.next()) {
				    for(int i = 1; i < columnsNumber; i++)
				    System.out.print(String.format("|%-20s",itemsRS.getString(i) + "   "));
				        		
				    System.out.println();
				}
				}catch (SQLException e) {
					System.out.println("Exception: " + e.getMessage());
					e.printStackTrace();
				}
			//connectionService.finalize();
			
			System.out.println("\nWhat can I get you? Please tell me the name of the drink you would like.");
			String drinkName = scan.next();
			//drinkName = drinkName.replaceAll("\\s","");
			

			System.out.println("Coming right up!");

			System.out.println("Alright! Here is the "+drinkName+" you asked for :)");
			
			
			
			try {
				PreparedStatement subtractStock = connectionService.getConnection().prepareStatement(
						"UPDATE stock SET stockadmin = stockadmin - 5 WHERE alcohol_name = ?");
						subtractStock.setString(1, drinkName);
						subtractStock.execute();
				}catch (SQLException e) {
					System.out.println("Exception: " + e.getMessage());
					e.printStackTrace();
				}
			
			try {
				PreparedStatement addMoney = connectionService.getConnection().prepareStatement(
						"SELECT SUM(alcohol_price)\r\n" + 
						"FROM stock\r\n" + 
						"WHERE alcohol_name = ?");
						addMoney.setString(1, drinkName);
							//addMoney.setString(1,  drinkName);
						addMoney.executeQuery();
				}catch (SQLException e) {
					System.out.println("Exception: " + e.getMessage());
					e.printStackTrace();
				}
			
			connectionService.finalize();
			
			System.out.println("\nCan I do anything else for you?\n[1] Order another drink\n[2] Close tab\n[3] Leave a tip");
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
				getDrinkMenu();
				break;
			case 2: 
				System.out.println("Alright, you're all clear! Have a great one");
				connectionService.finalize();
				break;
			case 3:
				System.out.println("Oh! How nice. How much would you like to tip?");
				String tipString = scan.next();
				int tipInt = 0;
				
				try {
					tipInt = Integer.parseInt(tipString);
				}
				catch(NumberFormatException optionExp){
					option=1;
					System.out.println("Hey, don't get fancy. No decimals or funny business now");
				}	
				try {
					PreparedStatement addTip = connectionService.getConnection().prepareStatement(
							"UPDATE tips SET tip_amount = tip_amount + ? WHERE bartender = ?");
							addTip.setInt(1, tipInt);
							addTip.setString(2, "Jacob");
							addTip.execute();
					}catch (SQLException e) {
						System.out.println("Exception: " + e.getMessage());
						e.printStackTrace();
					}
				System.out.println("Thank you very much! Anything else I can do for you?");
				System.out.println("\nCan I do anything else for you?\n[1] Order another drink\n[2] Close tab\n");
				String input2 = scan.next();
				int option2 = 0;
				try {
					option2 = Integer.parseInt(input2);
				}
				catch(NumberFormatException optionExp){
					option2=1;
					System.out.println("Hey, don't get fancy. No decimals or funny business now");
				}	
				switch(option2) {
				case 1:
					getDrinkMenu();
					break;
				case 2: 
					System.out.println("Alright, you're all clear! Have a great one");
					connectionService.finalize();
					break;
			}
			break;
			}
			return 0;
			
}
		
}


