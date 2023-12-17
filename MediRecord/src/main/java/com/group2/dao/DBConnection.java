package com.group2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// Class manages making connection to database.  Connection Working...

	// Declare Static variables to hold database information
	// Database URL and Name
	private static final String DB_NAME = "medirecord";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

	// Database User Info
	private static final String DB_USER = "CST8288Group2";			// change user name to match your user name
	private static final String DB_PASS = "CST8288Group2"; 	// change password to match your password

	public static Connection getConnectionToDatabase() {

		Connection connection = null;

		try {

			// load the driver class into memory
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQl JDBC Driver Registered!");

			// user DriverManager to make a connection
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		} 

		catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if(connection != null) {
			System.out.println("Connection made to database!");
		}


		return connection;

	}

}
