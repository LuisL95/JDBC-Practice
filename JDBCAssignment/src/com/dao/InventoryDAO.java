package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Inventory;

public class InventoryDAO {

private String message;
	
	public String addProdtoOutlet(Connection conn, Inventory inventory){
		
		PreparedStatement pst = null;
		
		String SQL  = "INSERT INTO INVENTORY (OUTLET_NUMBER, PRODUCT_CODE, quantity) VALUES(?,?,?)";
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, inventory.getOutletNumber());
			pst.setInt(2, inventory.getProductCode());
			pst.setInt(3, inventory.getQuantity());
			message = "NEW PRODUCT(S) ADDED CORRECTY TO OUTLET";
			pst.execute(); 
			pst.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message ="NEW PRODUCT(S) NOT ADDED CORRECTLY TO OUTLET" + e;
		}
		return message;
	}
	
	public int actualQuant = 0;
	public int getRowsById(Connection conn, Inventory inventory, int outletNumber, int productCode) {
			
			PreparedStatement pst = null;
			
			String SQL = "SELECT * FROM INVENTORY WHERE OUTLET_NUMBER = ? AND PRODUCT_CODE =?";
			ResultSet rs; 
			
			int nRows = 0;
			
			try {
				pst = conn.prepareStatement(SQL);
				pst.setInt(1, outletNumber);
				pst.setInt(2, productCode);
				rs = pst.executeQuery();
				
				rs.last();
				actualQuant = rs.getInt("quantity");
				nRows = rs.getRow();
				
				
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("NEW QUANTITY OF PRODUCT(S) NOT ADDED CORRECTLY TO OUTLET" + e);
			}
			return nRows;
		}
	
	
	public int getQuantity(Connection conn, Inventory inventory, int outletNumber, int productCode) {
		PreparedStatement pst = null;
		ResultSet rs;

		String SQL  = "SELECT quantity FROM INVENTORY WHERE OUTLET_NUMBER = ? AND PRODUCT_CODE =?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, outletNumber);
			pst.setInt(2, productCode);
			rs = pst.executeQuery();
			rs.last();
			actualQuant = rs.getInt("quantity");
			
		}catch(SQLException e) {
			
		}
		return actualQuant;
	}	
	
	public String modifyInventory(Connection conn, Inventory inventory, int outletNumber, int productCode){
		
		PreparedStatement pst = null;
		

		String SQL  = "UPDATE INVENTORY SET  quantity = ? WHERE OUTLET_NUMBER = ? AND PRODUCT_CODE = ?";
				
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, inventory.getQuantity());
			pst.setInt(2, outletNumber);
			pst.setInt(3, productCode);
			message = "INVENTORY MODIFIED CORRECTY ";
			pst.execute();
			pst.close();
				
					
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			System.err.println("INVENTORY NOT MODIFIED CORRECTLY" + e);
		}
				
			return message;
	}
	
	
	public String dropInventory(Connection conn, int outletNumber, int productCode){
		
		PreparedStatement pst = null;
		String SQL = "DELETE FROM INVENTORY WHERE OUTLET_NUMBER = ? AND PRODUCT_CODE = ?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, outletNumber);
			pst.setInt(2, productCode );
			message = "INVENTORY DROPPED CORRECTLY";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "INVENTORY NOT DROPPED CORRECTLY" + e.getMessage();
		}
		
		return message;
	}
	
	public void listOutlet(){
		
	}
}
