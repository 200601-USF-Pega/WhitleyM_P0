package com.revature.FoolLickerBar;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class ServicesTest {
	
		//YOU HAVE TO INPUT A VALUE IN THE CONSOLE FOR TESTS TO RUN
		/*@Test
		public void scannerTest(){
			Scanner testScan = new Scanner(System.in);
			String result = testScan.next();
			assertTrue(result!=null);
		}*/
	
		@Test
		public void bigInputValidationTest() {
			boolean test = false;
			String userNameValid="iAmMuchTooLongForThis";
			if (userNameValid.length() > 15 || userNameValid.length() < 5) {
				test = true;
			}
			assertTrue(test);
		}
		
		@Test
		public void smallInputValidationTest() {
			boolean test = false;
			String userNameValid="smol";
			if (userNameValid.length() > 15 || userNameValid.length() < 5) {
				test = true;
			}
			assertTrue(test);
		}
		
		@Test
		public void correctInputValidationTest() {
			boolean test = true;
			String userNameValid="justRight";
			if (userNameValid.length() > 15 || userNameValid.length() < 5) {
				test = false;
			}
			assertTrue(test);
		}
		
		@Test
		public void invalidIntegerValidationTest() {
			String prompt = "3.4";
			int userInput = 0;
			boolean test = false;

				//System.out.println(prompt);
				try {
					userInput = Integer.parseInt(prompt);
				} catch (NumberFormatException ex) {
					test = true;
				}
			assertTrue(test);
		}
		
		@Test
		public void validIntegerValidationTest() {
			String prompt = "45000";
			int userInput = 0;
			boolean test = true;

				//System.out.println(prompt);
				try {
					userInput = Integer.parseInt(prompt);
				} catch (NumberFormatException ex) {
					test = false;
				}
			assertTrue(test);
		}
		
		@Test
		public void invalidStringValidationtest() {
			String userInput="";
			boolean invalid = false;
				if (userInput.isEmpty()) {
					invalid = true;
				} 
			assertTrue(invalid);
		}
		
		@Test
		public void validStringValidationtest() {
			String userInput="this should return true";
			boolean invalid = true;
				if (userInput.isEmpty()) {
					invalid = false;
				} 
			assertTrue(invalid);
		}
		

}
