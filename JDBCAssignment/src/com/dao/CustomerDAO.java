package com.dao;

import java.sql.*;

import com.model.Customer;


public class CustomerDAO {
	
private String message;
	
	public String addCustomer(Connection conn, Customer customer){
		
		PreparedStatement pst = null;
		
		String SQL  = "INSERT INTO CUSTOMER (customer_name, address,  city, state, zip, phone) VALUES(?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, customer.getCustomerName());
			pst.setString(2, customer.getAddress());
			pst.setString(3, customer.getCity());
			pst.setString(4, customer.getState());
			pst.setString(5, customer.getZip());
			pst.setInt(6, customer.getPhone());
			message = "NEW CUSTOMER ADDED CORRECTY ";
			pst.execute();
			pst.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("NEW CUSTOMER NOT ADDED CORRECTLY" + e);
		}
		return message;
	}
	
	public int getRows(Connection conn, Customer customer, String customerName) {
		
		PreparedStatement pst = null;
		
		String SQL = "SELECT * FROM CUSTOMER WHERE customer_name = ?";
		ResultSet rs; 
		int nRows = 0;
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, customerName);
			
			rs = pst.executeQuery();
			rs.last();
			nRows = rs.getRow();
			pst.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		return nRows;
	}
	
	public int getRowsById(Connection conn, Customer customer, int customerId) {
			
			PreparedStatement pst = null;
			
			String SQL = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
			ResultSet rs; 
			int nRows = 0;
			
			try {
				pst = conn.prepareStatement(SQL);
				pst.setInt(1, customerId);
				
				rs = pst.executeQuery();
				rs.last();
				nRows = rs.getRow();
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
			return nRows;
		}
	
	
	public String modifyCustomer(Connection conn, Customer customer, String customerName){
		
		PreparedStatement pst = null;
		

		String SQL  = "UPDATE CUSTOMER SET customer_name = ?, address = ?,  city = ?, state = ?, zip = ?, phone = ? WHERE customer_name = ?";
				
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, customer.getCustomerName());
			pst.setString(2, customer.getAddress());
			pst.setString(3, customer.getCity());
			pst.setString(4, customer.getState());
			pst.setString(5, customer.getZip());
			pst.setInt(6, customer.getPhone());
			pst.setString(7, customerName);
			message = "CUSTOMER MODIFIED CORRECTY ";
			pst.execute();
			pst.close();
				
					
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			System.err.println(" CUSTOMER NOT MODIFIED CORRECTLY" + e);
		}
				
			return message;
	}
	
	
	public String dropCustomer(Connection conn, int customerId){
		
		PreparedStatement pst = null;
		String SQL = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID =?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, customerId);
			message = "CUSTOMER DROPPED CORRECTLY";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "CUSTOMER NOT DROPPED CORRECTLY" + e.getMessage();
		}
		
		return message;
	}
	
	public void listCustomer(){
		
	}

}
