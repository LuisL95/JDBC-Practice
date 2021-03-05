package com.bo;

import java.sql.Connection;

import com.dao.CustomerDAO;
import com.db.ConnectDB;
import com.model.Customer;

public class CustomerBO {
	private String message = " ";
	private CustomerDAO odao = new CustomerDAO();
	
	public String addCustomer(Customer customer) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.addCustomer(conn, customer);
			
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
	
	public int getRows(Customer customer, String customerName) {
			Connection conn = ConnectDB.getConnection();
			int result = odao.getRows(conn, customer, customerName);
			return result;
	}
	
	public int getRowsById(Customer customer, int customerId) {
		Connection conn = ConnectDB.getConnection();
		int result = odao.getRowsById(conn, customer, customerId);
		return result;
}
	
	public String modifyCustomer(Customer customer, String customerName) {
			
			Connection conn = ConnectDB.getConnection();
			try {
				
				message = odao.modifyCustomer(conn, customer, customerName);
				
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
	
	
	public String dropCustomer(int customerId) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.dropCustomer(conn, customerId);
			
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
