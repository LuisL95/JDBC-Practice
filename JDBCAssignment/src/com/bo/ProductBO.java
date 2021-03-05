package com.bo;

import java.sql.Connection;

import com.dao.ProductDAO;
import com.db.ConnectDB;
import com.model.Product;

public class ProductBO {

	private String message = " ";
	private ProductDAO odao = new ProductDAO();
	
	public String addProduct(Product product) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.addProduct(conn, product);
			
		}catch(Exception e) {
			
			message = e.getMessage();
		}finally {
			try {
				if (conn !=null) {
					conn.close();
				}
			}catch(Exception e){
				message = e.getMessage();
			}
		}
		return message;
	}
	
	public int getRows(Product product, String productName) {
			Connection conn = ConnectDB.getConnection();
			int result = odao.getRows(conn, product, productName);
			return result;
	}
	
	public int getRowsById(Product product, int productNum) {
		Connection conn = ConnectDB.getConnection();
		int result = odao.getRowsById(conn, product, productNum);
		return result;
}
	
	public String modifyProduct(Product product, String productName) {
			
			Connection conn = ConnectDB.getConnection();
			try {
				
				message = odao.modifyProduct(conn, product, productName);
				
			}catch(Exception e) {
				
				message = e.getMessage();
			}finally {
				try {
					if (conn !=null) {
						conn.close();
					}
				}catch(Exception e){
					message = e.getMessage();
				}
			}
			return message;
		}
	
	
	public String dropProduct(int productNumber) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.dropProduct(conn, productNumber);
			
		}catch(Exception e) {
			
			message = e.getMessage();
		}finally {
			try {
				if (conn !=null) {
					conn.close();
				}
			}catch(Exception e){
				message = e.getMessage();
			}
		}
		return message;
	}
}
