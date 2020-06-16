package com.revature.FoolLickerBar.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.FoolLickerBar.models.Stock;
import com.revature.FoolLickerBar.services.ConnectionService;

public class AlcoholStockDB implements IAlcoholStockDB{
	
	ConnectionService connectionService;
	
	public AlcoholStockDB(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	@Override
	public List<Stock> getAllItems() {
		Statement st = null;
		try {
	
		ResultSet rs = st.executeQuery("SELECT * from contacts");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();

		while (rs.next()) {
		    for(int i = 1; i < columnsNumber; i++)
		        System.out.print(rs.getString(i) + " ");
		    System.out.println();
		}
		}catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub
		/*try {			
			PreparedStatement getStock = connectionService.getConnection().prepareStatement(
					"SELECT * FROM stock;");
			ResultSet itemsRS = getStock.executeQuery();
			
			List<Stock> stockList = new ArrayList<Stock>();
			
			while(itemsRS.next()) {				
				Stock newStock = new Stock(
					itemsRS.getString("alcohol_type"),
					itemsRS.getString("alcohol_name"),
					itemsRS.getInt("alcohol_content"),
					itemsRS.getInt("alcohol_price"));	
				
				stockList.add(newStock);
			}	
			return stockList;
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return new ArrayList<Stock>();
		*/
	}

	@Override
	public List<Stock> getSomeItems(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
