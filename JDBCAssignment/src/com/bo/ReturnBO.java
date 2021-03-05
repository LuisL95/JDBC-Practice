package com.bo;

import java.sql.Connection;
import java.sql.Date;

import com.dao.ReturnDAO;
import com.db.ConnectDB;
import com.model.Return;
import com.model.Sale;

public class ReturnBO {

private String message = " ";
	
	private ReturnDAO rdao = new ReturnDAO();
	
	public String ProcessReturn(Return ret) {
		
			
			Connection conn = ConnectDB.getConnection();
			try {
				
				message = rdao.ProcessReturn(conn, ret);
				
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
	
	public String viewReturn(Return ret, Date date,  int customerId) {
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = rdao.viewReturn(conn, ret, date,  customerId);
			
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
	
	public int getQuantity(Return ret, int outletNumber,  int customerId, int productCode) {
		Connection conn = ConnectDB.getConnection();
		int result  =rdao.getQuantity(conn, ret, outletNumber,  customerId, productCode);	
		return result;
		
	}


}
