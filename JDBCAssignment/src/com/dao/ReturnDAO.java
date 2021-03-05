package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Return;

public class ReturnDAO {
	
	private String message;
	
public String ProcessReturn(Connection conn, Return ret){
		
		PreparedStatement pst = null;
		
		
		String SQL  = "INSERT INTO RETURNS (OUTLET_NUMBER, CUSTOMER_ID, PRODUCT_CODE, RETURN_DATE, RETURN_TIME, quantity, reason)"
				+ " VALUES(?,?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(SQL);
			
			
			
			pst.setInt(1, ret.getOutletNumber());
			pst.setInt(2, ret.getCostumerId());
			pst.setInt(3, ret.getProductCode());
			pst.setDate(4, ret.getReturnDate());
			pst.setTime(5, ret.getReturnTime());
			pst.setInt(6, ret.getQuantity());
			pst.setString(7, ret.getReason());
			message = "NEW RETURN PROCESSED CORRECTY ";
			pst.execute();
			pst.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "NEW RETURN NOT PROCESSED CORRECTLY" + e;
		}
		return message;
	}
	
	public String viewReturn(Connection conn,Return ret, Date date, int customerId) {
		
		PreparedStatement pst = null;
		ResultSet rs;
		
		String SQL = "SELECT * FROM RETURNS WHERE RETURN_DATE =?  AND CUSTOMER_ID =?";
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setDate(1, date);
			
			pst.setInt(2, customerId);
			rs = pst.executeQuery();
			StringBuffer buffer = new StringBuffer();
			while(rs.next()) {
				
				
				
				buffer.append("OUTLET_NUMBER: " + rs.getInt("OUTLET_NUMBER")+"\n" );
				buffer.append("CUSTOMER_ID: " + rs.getInt("CUSTOMER_ID")+"\n" );
				buffer.append("PRODUCT_CODE: " + rs.getInt("PRODUCT_CODE")+"\n" );
				buffer.append("RETURN_DATE: " + rs.getDate("RETURN_DATE")+"\n" );
				buffer.append("RETURN_TIME: " + rs.getTime("RETURN_TIME") +"\n" );
				buffer.append("quantity: " + rs.getInt("quantity")+"\n" );
				buffer.append("reason: " + rs.getString("reason")+"\n" );
				buffer.append("--------------------\n" );
				
				message = buffer.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "RETURN NOT FOUND"+e;
		}
		return message;
		
	}
	
	public int getQuantity(Connection conn,Return ret, int outletNumber, int customerId, int productCode) {
			
		PreparedStatement pst = null;
		ResultSet rs;
		
		String SQL = "SELECT quantity FROM RETURNS WHERE OUTLET_NUMBER =?  AND CUSTOMER_ID =? AND PRODUCT_CODE = ?";
		int returnQuantity = 0;
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, outletNumber);
			pst.setInt(2, customerId);
			pst.setInt(3, productCode);
			rs = pst.executeQuery();
			while(rs.next()) {
				returnQuantity += rs.getInt("quantity");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SALE NOT FOUND"+e); 
		}
		return returnQuantity;
	
	}


}
