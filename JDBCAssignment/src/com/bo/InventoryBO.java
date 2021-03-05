package com.bo;

import java.sql.Connection;

import com.dao.InventoryDAO;
import com.db.ConnectDB;
import com.model.Inventory;

public class InventoryBO {
	

	private String message = " ";
	
	private InventoryDAO odao = new InventoryDAO();
	
	public int actualQuant = odao.actualQuant;

	
	public String addInventory(Inventory inventory) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.addProdtoOutlet(conn, inventory);
			
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
	
	public int getQuantity(Inventory inventory, int outletNumber, int ProductCode) {
		Connection conn = ConnectDB.getConnection();
		int result = odao.getQuantity(conn, inventory, outletNumber, ProductCode);
		return result;
	}
	
	
	public int getRowsById(Inventory inventory, int outletNumber, int ProductCode) {
		Connection conn = ConnectDB.getConnection();
		int result = odao.getRowsById(conn, inventory, outletNumber, ProductCode);
		return result;
    }
	public int addQuantity(int newQuant) {
		
		this.actualQuant = actualQuant + newQuant;
		
		return actualQuant;
	}
	
	
	public int restQuantity(int newQuant) {
		
		actualQuant = actualQuant - newQuant;
		
		return actualQuant;
	}
	
	
	public String modifyInventory(Inventory inventory, int outletNumber, int ProductCode) {
			
			Connection conn = ConnectDB.getConnection();
			try {
				
				message = odao.modifyInventory(conn, inventory, outletNumber, ProductCode);
				
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
	
	
	public String dropInventory(int outletNumber, int ProductCode) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.dropInventory(conn,  outletNumber, ProductCode);
			
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
