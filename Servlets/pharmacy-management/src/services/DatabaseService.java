package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
	
		private final String driverClassName = "com.mysql.cj.jdbc.Driver";
		private final String databaseName = "zoho_pharma";
		private final String databaseUrl = "jdbc:mysql://localhost:3306/" + databaseName;
		private final String databaseUsername = "root";
		private final String databasePassword = "";
			
		private static DatabaseService service = null;
		
		private	DatabaseService() {
			try {
				Class.forName(driverClassName);
			} catch (ClassNotFoundException e) {
				System.out.println("Looks like you are missing the database driver!");
			}			
		}
		
		public Connection getConnection() throws SQLException {
			return DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
		}
		
		public static DatabaseService getInstance() {
			if(service == null) 
				service = new DatabaseService();
			
			return service;
		}
	
}
