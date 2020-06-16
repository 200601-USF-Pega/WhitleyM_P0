package com.revature.FoolLickerBar.services;

import java.util.Scanner;

public class ValidationService {

	Scanner input = new Scanner(System.in);
	boolean invalid = true;
	
	public int getValidInt(String prompt) {
		int userInput = 0;
		do {
			//System.out.println(prompt);
			try {
				userInput = Integer.parseInt(prompt);
			} catch (NumberFormatException ex) {
				System.out.println("Hey, don't get fancy. No decimals or funny business now");
				break;
			}
		} while(invalid);
		return userInput;
		//try super keyword to toss it back to who called it
	}
	
	public String getValidString() {
		String userInput;
		boolean invalid = true;
		do {
			userInput = input.nextLine();
			if (!userInput.isEmpty()) {
				invalid = false;
				break;
			} else {
				System.out.println("Nice try...Maybe use an actual input this time?");
			}
		} while (invalid);
		return userInput;
	}
}
