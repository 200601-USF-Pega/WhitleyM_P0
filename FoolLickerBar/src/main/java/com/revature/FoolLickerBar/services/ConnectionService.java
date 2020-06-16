package com.revature.FoolLickerBar.services;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;

public class ConnectionService {
private Connection connection;
	
	public ConnectionService() {
		try  {
			FileInputStream fis = new FileInputStream("connection.prop");
			Properties p = new Properties();
			p.load(fis);
			
			connection = DriverManager.getConnection(p.getProperty("jdbc:postgresql://ruby.db.elephantsql.com:5432/wrdfegjq"), 
					p.getProperty("wrdfegjq"), p.getProperty("nWnAGBnhrbJDKE4XVaOWbYW_qHbTPD3l"));
			//input your shit here
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	@Override
	public void finalize() {
		try {
			connection.close();
		} catch(Exception e) {
			
		}
	}
}
