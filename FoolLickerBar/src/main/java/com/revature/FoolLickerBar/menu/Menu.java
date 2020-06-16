package com.revature.FoolLickerBar.menu;
import java.util.Scanner;

import com.revature.FoolLickerBar.services.GuestService;

public class Menu {
	
		public void mainMenu() {
			System.out.println("Howdy, and welcome to our Fool Licker bar!");
			System.out.println("What would you like to do?");
			System.out.println("[0] Start a tab");
			System.out.println("[1] Clock in for a bartending shift");
			System.out.println("[2] Access Fool Licker bar admin page");
			System.out.println("[3] Exit");
			
			Scanner scan = new Scanner(System.in);
			String input = scan.next();
			int option;
			
			try {
				option = Integer.parseInt(input);
			}
			catch(NumberFormatException optionExp){
				option=1;
				System.out.println("Hey, don't get fancy. No decimals or funny business now");
			}	
			
				switch(option) {
				case 0: 
					GuestService caseZero = new GuestService();
					caseZero.createNewTab();
					break;
				case 1:
					//System.out.println("Exiting...");

					break;		
				case 2:

					break;
				case 3:
					System.out.println("Exiting...");
	
					break;
				default: 
					System.out.println("Sorry pal. You have to choose from one of the options listed above");
				}
				}
	
			
		
			
		}
