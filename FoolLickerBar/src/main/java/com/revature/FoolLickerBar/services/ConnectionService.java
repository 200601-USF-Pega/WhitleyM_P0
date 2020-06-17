package com.revature.FoolLickerBar.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;

public class ConnectionService {
private static Connection connection;
	
	public ConnectionService() {
		
	}
	
	public static Connection getConnection() {
		try  {
			FileInputStream fis = new FileInputStream("connection.prop");
			Properties p = new Properties();
			p.load(fis);
			
			connection = DriverManager.getConnection(p.getProperty("hostname"), 
					p.getProperty("username"), p.getProperty("password"));
			//input your shit in a connection.prop file
		} catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return connection;
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
