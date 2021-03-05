package com.db;

import java.sql.*;

import com.dao.OutletDAO;


public class ConnectDB {

	private static final String USERNAME = "luis";
	private static final String PASSWORD = "luis123";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3307/musicstore";
	
	
	public static Connection getConnection() {
		
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Connected!!");
			
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
		
		return conn;
	}
	 
}
