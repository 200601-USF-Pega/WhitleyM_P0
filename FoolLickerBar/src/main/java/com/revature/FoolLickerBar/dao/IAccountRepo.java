package com.revature.FoolLickerBar.dao;

import com.revature.FoolLickerBar.models.Account;
import com.revature.FoolLickerBar.models.Guest;

public interface IAccountRepo {
	public Account addAccount(Account account, String name, String username, String password);
	public void removeAccount(String username);
	Account addAccount(Guest guest, String name, String username, String password);
}
