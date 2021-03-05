package com.bo;

import java.sql.Connection;

import com.dao.OutletDAO;
import com.db.ConnectDB;
import com.model.Outlet;

public class OutletBO {
	//sanchez.julio@tcs.com
	//oswaldo.enriquez@tccs.com

	private String message = " ";
	private OutletDAO odao = new OutletDAO();
	
	public String addOutlet(Outlet outlet) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.addOutlet(conn, outlet);
			
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
	
	public int getRows( String outletName) {
			Connection conn = ConnectDB.getConnection();
			int result = odao.getRows(conn, outletName);
			return result;
	}
	
	public int getRowsById( int outletNum) {
		Connection conn = ConnectDB.getConnection();
		int result = odao.getRowsById(conn, outletNum);
		return result;
}
	
	public String modifyOutlet(Outlet outlet, String outletName) {
			
			Connection conn = ConnectDB.getConnection();
			try {
				
				message = odao.modifyOutlet(conn, outlet, outletName);
				
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
	
	
	public String dropOutlet(int outletNumber) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.dropOutlet(conn, outletNumber);
			
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
