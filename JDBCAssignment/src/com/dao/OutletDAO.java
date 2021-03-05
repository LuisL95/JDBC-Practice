package com.dao;

import java.sql.*;

import com.model.Outlet;

public class OutletDAO {

	
	private String message;
	
	public String addOutlet(Connection conn, Outlet outlet){
		
		PreparedStatement pst = null;
		
		String SQL  = "INSERT INTO OUTLET (name, address,  city, state, zip, phone) VALUES(?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, outlet.getName());
			pst.setString(2, outlet.getAddress());
			pst.setString(3, outlet.getCity());
			pst.setString(4, outlet.getState());
			pst.setString(5, outlet.getZip());
			pst.setInt(6, outlet.getPhone());
			message = "NEW OUTLET ADDED CORRECTY ";
			pst.execute();
			pst.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("NEW OUTLET NOT ADDED CORRECTLY" + e);
		}
		return message;
	}
	
	public int getRows(Connection conn, String outletName) {
		
		PreparedStatement pst = null;
		
		String SQL = "SELECT * FROM OUTLET WHERE name = ?";
		ResultSet rs; 
		int nRows = 0;
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, outletName);
			
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
	
	public int getRowsById(Connection conn, int outletNum) {
			
			PreparedStatement pst = null;
			
			String SQL = "SELECT * FROM OUTLET WHERE OUTLET_NUMBER = ?";
			ResultSet rs; 
			int nRows = 0;
			
			try {
				pst = conn.prepareStatement(SQL);
				pst.setInt(1, outletNum);
				
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
	
	
	public String modifyOutlet(Connection conn, Outlet outlet, String outletName){
		
		PreparedStatement pst = null;
		

		String SQL  = "UPDATE OUTLET SET name = ?, address = ?,  city = ?, state = ?, zip = ?, phone = ? WHERE name = ?";
				
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, outlet.getName());
			pst.setString(2, outlet.getAddress());
			pst.setString(3, outlet.getCity());
			pst.setString(4, outlet.getState());
			pst.setString(5, outlet.getZip());
			pst.setInt(6, outlet.getPhone());
			pst.setString(7, outletName);
			message = "OUTLET MODIFIED CORRECTY ";
			pst.execute();
			pst.close();
				
					
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			System.err.println(" OUTLET NOT MODIFIED CORRECTLY" + e);
		}
				
			return message;
	}
	
	
	public String dropOutlet(Connection conn, int outletNumber){
		
		PreparedStatement pst = null;
		String SQL = "DELETE FROM OUTLET WHERE OUTLET_NUMBER =?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, outletNumber);
			message = "OULET DROPPED CORRECTLY";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "OUTLET NOT DROPPED CORRECTLY" + e.getMessage();
		}
		
		return message;
	}
	
	public void listOutlet(){
		
	}
		
}
