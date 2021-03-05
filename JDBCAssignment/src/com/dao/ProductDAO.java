package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.ConnectDB;
import com.model.Product;

public class ProductDAO {


	private String message;
	
	public String addProduct(Connection conn, Product product){
		
		PreparedStatement pst = null;
		
		String SQL  = "INSERT INTO PRODUCT (artist, title, cost, sale_price) VALUES(?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, product.getArtist());
			pst.setString(2, product.getTitle());
			pst.setDouble(3, product.getCost());
			pst.setDouble(4, product.getSalePrice());
			message = "NEW PRODUCT ADDED CORRECTY ";
			pst.execute();
			pst.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("NEW PRODUCT NOT ADDED CORRECTLY" + e);
		}
		return message;
	}
	
	public int getRows(Connection conn, Product product, String productTitle) {
		
		PreparedStatement pst = null;
		
		String SQL = "SELECT * FROM PRODUCT WHERE title = ?";
		ResultSet rs; 
		int nRows = 0;
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, productTitle);
			
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
	
	public int getRowsById(Connection conn, Product product, int productCode) {
			
			PreparedStatement pst = null;
			
			String SQL = "SELECT * FROM PRODUCT WHERE PRODUCT_CODE = ?";
			ResultSet rs; 
			int nRows = 0;
			
			try {
				pst = conn.prepareStatement(SQL);
				pst.setInt(1, productCode);
				
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
	
	
	public String modifyProduct(Connection conn, Product product, String productTitle){
		
		PreparedStatement pst = null;
		

		String SQL  = "UPDATE PRODUCT SET artist = ?, title = ?,  cost = ?, sale_price = ? WHERE title = ?";
				
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, product.getArtist());
			pst.setString(2, product.getTitle());
			pst.setDouble(3, product.getCost());
			pst.setDouble(4, product.getSalePrice());
			pst.setString(5, productTitle);
			message = "PRODUCT MODIFIED CORRECTY ";
			pst.execute();
			pst.close();
				
					
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			System.err.println("PRODUCT NOT MODIFIED CORRECTLY" + e);
		}
				
			return message;
	}
	
	
	public String dropProduct(Connection conn, int productCode){
		
		PreparedStatement pst = null;
		String SQL = "DELETE FROM PRODUCT WHERE PRODUCT_CODE =?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, productCode);
			message = "PRODUCT DROPPED CORRECTLY";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "PRODUCT NOT DROPPED CORRECTLY" + e.getMessage();
		}
		
		return message;
	}
	
	public void listOutlet(){
		
	}
}
