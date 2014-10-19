
package com.cs330.fall2013;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//Example of the Singleton pattern
//Ensures that only one instance is ever created (of this type)

public class ProgramAdvisorDataSourceSingleton {
	
	//create private static reference
	private static ProgramAdvisorDataSourceSingleton instance;
	
	private Connection con;
	
	private String username;
	private String password;
	private String driver;
	private String connectStr;
	
	//write getInstance to replace constructor
	public static ProgramAdvisorDataSourceSingleton getInstance(){
		if(instance == null) {
			instance = new ProgramAdvisorDataSourceSingleton();
		}
		return instance;
	}
	
	//made constructor private
	private ProgramAdvisorDataSourceSingleton() {
		con = null;
		Properties p = new Properties();
		try {
			//p.load(new FileInputStream("jdbc.properties"));
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
			p.load(inputStream);
			
			username = p.getProperty("jdbc.username");
			password = p.getProperty("jdbc.password");
			connectStr = p.getProperty("jdbc.connectStr");
			driver = p.getProperty("jdbc.driver");
			
		} catch (FileNotFoundException e) {
			//Write to log file @todo
			e.printStackTrace();
			//return "Error: Could not open properties file";
			
		} catch (IOException e) {
			e.printStackTrace();
			//return "Error: Could not parse properties file";
		}
		
	}//end constructor
	
	public Connection getConnection() {
		try {
			if(con != null && con.isValid(30)) {
				return con;
			}
			Class.forName(driver) ;
			con = DriverManager.getConnection(
					 connectStr, username, password);
				} 
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;

	}//end getConnection
	
	
	public static void main(String[] args) {
		
	}

}
