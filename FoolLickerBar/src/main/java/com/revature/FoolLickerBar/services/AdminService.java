package com.revature.FoolLickerBar.services;

import java.sql.*;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

import com.revature.FoolLickerBar.dao.IAlcoholStockDB;
import com.revature.FoolLickerBar.models.Account;
import com.revature.FoolLickerBar.*;

public class AdminService {
	
	IAlcoholStockDB repo;
	
		
		public AdminService(IAlcoholStockDB repo) {
			this.repo = repo;
		}
		
		public int getTotalStock(){
			ConnectionService connectionService = new ConnectionService();
			Statement st= null;
			Scanner scan = new Scanner(System.in);
			
			try {
				PreparedStatement getStock = connectionService.getConnection().prepareStatement(
							"SELECT * FROM stock;");
					ResultSet itemsRS = getStock.executeQuery();
			//	ResultSet rs = st.executeQuery("SELECT * from contacts");
				ResultSetMetaData rsmd = itemsRS.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				System.out.println(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s", "Alcohol Type", 
						"Alcohol Name", "Alcohol Content (%)", "Price", "Stock (oz)\n"));
				while (itemsRS.next()) {
				    for(int i = 1; i <= columnsNumber; i++)
				    System.out.print(String.format("|%-20s",itemsRS.getString(i) + "   "));
				        		
				    System.out.println();
				}
				}catch (SQLException e) {
					System.out.println("Exception: " + e.getMessage());
					e.printStackTrace();
				}
			connectionService.finalize();
			
			System.out.println("\nWould you like to check the bar's income?\n [1] Yes\n [2] No\n");
			String incomeCheck = scan.next();
			int option = 0;
			try {
				option= Integer.parseInt(incomeCheck);
			}
			catch(NumberFormatException optionExp){
				option=1;
				System.out.println("Hey, don't get fancy. No decimals or funny business now");
			}	
			switch(option) {
			case 1:
				getBarIncome();
				break;
			case 2: 
				System.out.println("Goodbye!");
				break;
			}
			return 0;
			
}
		
		
		public int getBarIncome() {
			return 0;
		}
		
		
		
		public void checkIfAdmin(){
			ConnectionService connectionService = new ConnectionService();
			Scanner scan = new Scanner(System.in);
			boolean loop = true;
			
			System.out.println("Oh, the Admin has arrived!\n");
			while(loop=true) {
			System.out.print("Please enter codename:  ");	
			String codename = scan.next();
			System.out.print("Please enter account type:  ");
			String accountType = scan.next();
			System.out.print("Please enter password:  ");
			String password = scan.next();
			Statement st;
			try {
				PreparedStatement userVerification = connectionService.getConnection().prepareStatement(
					"SELECT username, account_type, user_password FROM users WHERE username = ? AND account_type ="
					+ "? AND user_password = ?");
				userVerification.setString(1, codename);
				userVerification.setString(2, accountType);
				userVerification.setString(3, password);
				//userVerification.executeQuery();
				ResultSet rs = userVerification.executeQuery();
			
				if(rs.next()) {
					System.out.println("Login successful! Glad to see you \n");
					
					
				//THIS NEXT PART OF CODE IS SO UGLY I AM SORRY
					
					connectionService.finalize();
					//loop=false; <-- for some reason this does nothing to stop the while loop, so i broke out of it manually
					//connectionService.close();
					System.out.println("So, boss...what would you like to do?\n [1] Review the bar's stock \n "
							+ "[2] Review the bar's income \n [3] Realize that this bar is causing emotional strains on your social relations\n");
					String adminInput = scan.next();
					int option = 0;
					try {
						option= Integer.parseInt(adminInput);
					}
					catch(NumberFormatException optionExp){
						option=1;
						System.out.println("Hey, don't get fancy. No decimals or funny business now");
					}	
					switch(option) {
					case 1:
						getTotalStock();
						break;
					case 2:
						getBarIncome();
						break;
					case 3:
						System.out.println("HA! You are TOO funny! Anyways, back to work. Let's go ahead and check our money, shall we? ");
						getBarIncome();
						break;
					}
				break;
				}else {
					System.out.println("Login not successful. Try again \n");
				}
	
				
			}catch (SQLException e) {
				System.out.println("Exception: " + e.getMessage());
				e.printStackTrace();
			}
			}
		}
}





