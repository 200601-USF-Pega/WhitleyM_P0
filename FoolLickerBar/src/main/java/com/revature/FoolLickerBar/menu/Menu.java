package com.revature.FoolLickerBar.menu;
import java.util.Scanner;

import com.revature.FoolLickerBar.dao.IAlcoholStockDB;
import com.revature.FoolLickerBar.services.GuestService;
import com.revature.FoolLickerBar.services.ValidationService;
import com.revature.FoolLickerBar.*;

public class Menu {
		IAlcoholStockDB repo;
		public void mainMenu() {
			System.out.println("Howdy, and welcome to our Fool Licker bar!");
			System.out.println("What would you like to do?");
			System.out.println("[0] Start a tab");
			System.out.println("[1] Clock in for a bartending shift");
			System.out.println("[2] Access Fool Licker bar admin page");
			System.out.println("[3] Exit");
			
			boolean startLoop=true;
			boolean caseZeroLoop=true;
			Scanner scan = new Scanner(System.in);
			ValidationService validationService = new ValidationService();
			
			do {
			String input = scan.next();
			int option=0;
			
			//ValidationService optionCheck = new ValidationService();
		//	optionCheck.getValidInt(input);
			
			try {
				option = Integer.parseInt(input);
			}
			catch(NumberFormatException optionExp){
				option=1;
				System.out.println("Hey, don't get fancy. No decimals or funny business now");
			}	
			
	
			
			
			
				switch(option) {
				case 0: 
					GuestService caseZero = new GuestService(repo);
					//System.out.println("Hello friend. This is probably the most work you've had to do to pay somebody else money! Hahaha! Anyways...");
					//System.out.println("");
					
				
					caseZero.createNewTab();
					startLoop=false;
					break;
				case 1:
					//System.out.println("Exiting...");
					startLoop=false;
					break;		
				case 2:
					startLoop=false;
					break;
				case 3:
					System.out.println("Exiting...");
					startLoop=false;
					break;
				default: 
					System.out.println("Sorry pal. You have to choose from one of the options listed above");
				}
				
				}while(startLoop==true);
		}
	
			
		
			
		}
