package com.revature.FoolLickerBar.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.FoolLickerBar.dao.IAlcoholStockDB;
import com.revature.FoolLickerBar.models.Guest;

public class BartenderService {
	ConnectionService connectionService = new ConnectionService();
	ValidationService inputValidation = new ValidationService();
	
	IAlcoholStockDB repo;

	
	public BartenderService(IAlcoholStockDB repo) {
		this.repo = repo;
	}
		
		public int getTotalStock(){
			ConnectionService connectionService = new ConnectionService();
			ValidationService inputValidation = new ValidationService();
			Scanner scan = new Scanner(System.in);
			AccountService service = new AccountService((connectionService));

			
			Statement st= null;
			try {
				PreparedStatement getStock = connectionService.getConnection().prepareStatement(
							"SELECT * FROM stock;");
					ResultSet itemsRS = getStock.executeQuery();
			//	ResultSet rs = st.executeQuery("SELECT * from contacts");
				ResultSetMetaData rsmd = itemsRS.getMetaData();
				int columnsNumber = rsmd.getColumnCount();

				while (itemsRS.next()) {
				    for(int i = 1; i <= columnsNumber; i++)
				        System.out.print(itemsRS.getString(i) + "    ");
				    System.out.println();
				}
				}catch (SQLException e) {
					System.out.println("Exception: " + e.getMessage());
					e.printStackTrace();
				}
			return 0;	
}
		
		public Guest getGuests(Guest guest) {
			return guest;
		}
		
}
