package com.revature.FoolLickerBar.services;
import java.util.Scanner;

//import Exceptions.InvalidHealthValueException;
//import Model.Hero;

public class GuestService {


	//import com.revature.tourofheroes.exceptions.InvalidHealthException;
	//import com.revature.tourofheroes.models.Hero;
	
		public boolean createNewTab() {

			//Hero newHero;
			Scanner scan = new Scanner(System.in);

			
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
					AccountService caseOne = new AccountService();
					caseOne.createNewAccount();
					//call create account method
					break;
				case 2:
					AccountService caseTwo = new AccountService();
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
		
				
				
		
	
		
		
	
			return true;
}
}
