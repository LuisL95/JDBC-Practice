package com.bo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;

import com.dao.SaleDAO;
import com.db.ConnectDB;
import com.model.Sale;

public class SaleBO {
	
	private String message = " ";
	
	private SaleDAO sdao = new SaleDAO();
	
	public String ProcessSale(Sale sale) {
		
			
			Connection conn = ConnectDB.getConnection();
			try {
				
				message = sdao.ProcessSale(conn, sale);
				
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
	
	public String viewSale(Sale sale, Date date,  int customerId) {
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = sdao.viewSale(conn, sale, date,  customerId);
			
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
	
	public String SYReport(int year,  int outletNumber) {
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = sdao.SYReport(conn,  year,  outletNumber);
		
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
	
	public String SEReport(int empNumber) {
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = sdao.SEReport(conn, empNumber);
		
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
	
	public String topProducts() {
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = sdao.topProducts(conn);
		
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
	
	public int getQuantity(Sale sale, int outletNumber,  int customerId, int productCode) {
		Connection conn = ConnectDB.getConnection();
		
		int result = sdao.getQuantity(conn, sale, outletNumber, customerId, productCode);
		return result;
		
	}

}
