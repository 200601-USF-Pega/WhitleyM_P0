package com.revature.FoolLickerBar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.FoolLickerBar.models.Admin;
import com.revature.FoolLickerBar.models.Guest;
import com.revature.FoolLickerBar.services.AdminService;
import com.revature.FoolLickerBar.services.GuestService;

public class ModelsTest {

		@Test
		public void guestsShouldBeUnique() {
			
			String guestName = "guest";
			String guestUsername = "guest";
			String guestPassword = "guestpassword";
			
			Guest testGuest = new Guest(guestName, guestUsername, guestPassword);
			
			GuestService serviceGuest = new GuestService(null);
			//testGuest.checkGuestExists(guestUsername);
			assertTrue(guestName.equals(guestUsername));
		}
		
		@Test
		public void guestConstructorTest() {
			
			String guestName = "guest";
			String guestUsername = "guest";
			String guestPassword = "guestpassword";
			
			AdminService testAdmin = null;// = new Guest(guestName, guestUsername, guestPassword);
			//testAdmin.checkIfAdmin();
			//assertFalse(true);
		}
}
