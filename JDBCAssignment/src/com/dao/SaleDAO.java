package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.NumberFormat;
import java.util.Calendar;

import com.bo.*;
import com.model.*;


public class SaleDAO {
	
	
	private String message;
	
	/*
	 * Inventory inventory = new Inventory(); Outlet outlet = new Outlet(); Employee
	 * employee = new Employee(); Product product = new Product(); Customer customer
	 * = new Customer();
	 * 
	 * InventoryBO invBO = new InventoryBO(); OutletBO outBO = new OutletBO();
	 * EmployeeBO empBO = new EmployeeBO(); ProductBO prodBO = new ProductBO();
	 * CustomerBO cusBO = new CustomerBO();
	 */
	
	public String ProcessSale(Connection conn, Sale sale){
		
		PreparedStatement pst = null;
		
		
		String SQL  = "INSERT INTO SALES (OUTLET_NUMBER, EMP_NUMBER, CUSTOMER_ID, PRODUCT_CODE, SALE_DATE, SALE_TIME, quantity)"
				+ " VALUES(?,?,?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(SQL);
			
			/*
			 * if(outBO.getRowsById(outlet, sale.getOutletNumber())!=0) { pst.setInt(1,
			 * sale.getOutletNumber()); }else {
			 * System.out.println("Outlet number NOT found"); }
			 * 
			 * if(empBO.getRowsById(employee, sale.getEmpNumber())!=0) { pst.setInt(2,
			 * sale.getEmpNumber()); }else {
			 * System.out.println("Employee number NOT found"); }
			 * 
			 * if(cusBO.getRowsById(customer, sale.getCostumerId())!=0) { pst.setInt(3,
			 * sale.getCostumerId()); }else { System.out.println("Customer Id NOT found"); }
			 * 
			 * if(prodBO.getRowsById(product, sale.getProductCode())!=0) { pst.setInt(4,
			 * sale.getProductCode()); }else {
			 * System.out.println("Product Code Id NOT found"); }
			 * 
			 * 
			 * pst.setDate(5, sale.getSaleDate()); pst.setTime(6, sale.getSaleTime());
			 * 
			 * 
			 * if((invBO.getRowsById(inventory, sale.getOutletNumber(),
			 * sale.getProductCode())) != 0) { if (sale.getQuantity() <= invBO.actualQuant )
			 * { if(sale.getQuantity()<0) { pst.setInt(7, sale.getQuantity());
			 * 
			 * invBO.restQuantity(sale.getQuantity()); }else
			 * {System.out.println("Must be a positive number");} }else
			 * {System.out.println("Quantity not avaliable");} }
			 */
			
			pst.setInt(1, sale.getOutletNumber());
			pst.setInt(2, sale.getEmpNumber());
			pst.setInt(3, sale.getCostumerId());
			pst.setInt(4, sale.getProductCode());
			pst.setDate(5, sale.getSaleDate());
			pst.setTime(6, sale.getSaleTime());
			pst.setInt(7, sale.getQuantity());
			message = "NEW SALE PROCESSED CORRECTY ";
			pst.execute();
			pst.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "NEW SALE NOT PROCESSED CORRECTLY" + e;
		}
		return message;
	}
	
	public String viewSale(Connection conn,Sale sale, Date date, int customerId) {
		
		PreparedStatement pst = null;
		ResultSet rs;
		
		String SQL = "SELECT * FROM SALES WHERE SALE_DATE =?  AND CUSTOMER_ID =?";
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setDate(1, date);
			
			pst.setInt(2, customerId);
			rs = pst.executeQuery();
			StringBuffer buffer = new StringBuffer();
			while(rs.next()) {
				
				
				
				buffer.append("OUTLET_NUMBER: " + rs.getInt("OUTLET_NUMBER")+"\n" );
				buffer.append("EMP_NUMBER: " + rs.getInt("EMP_NUMBER")+"\n" );
				buffer.append("CUSTOMER_ID: " + rs.getInt("CUSTOMER_ID")+"\n" );
				buffer.append("PRODUCT_CODE: " + rs.getInt("PRODUCT_CODE")+"\n" );
				buffer.append("SALE_DATE: " + rs.getDate("SALE_DATE")+"\n" );
				buffer.append("SALE_TIME: " + rs.getTime("SALE_TIME") +"\n");
				buffer.append("quantity: " + rs.getInt("quantity")+"\n" );
				buffer.append("--------------------\n" );
				
				message = buffer.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "SALE NOT FOUND"+e;
		}
		return message;
		
	}
	
	public int getQuantity(Connection conn,Sale sale, int outletNumber, int customerId, int productCode) {
		
		PreparedStatement pst = null;
		ResultSet rs;
		
		String SQL = "SELECT quantity FROM SALES WHERE OUTLET_NUMBER =?  AND CUSTOMER_ID =? AND PRODUCT_CODE = ?";
		int saleQuantity = 0;
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, outletNumber);
			pst.setInt(2, customerId);
			pst.setInt(3, productCode);
			rs = pst.executeQuery();
			while(rs.next()) {
				saleQuantity += rs.getInt("quantity");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SALE NOT FOUND"+e); 
		}
		return saleQuantity;
		
	}
	
		public String SYReport(Connection conn, int year, int ouletNumber) {
				
				PreparedStatement pst = null;
				ResultSet rs;
				
				String SQL = "SELECT * FROM SALES WHERE OUTLET_NUMBER =?   AND SALE_DATE BETWEEN ? AND ? ";
				
				try {
					
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.YEAR, year);
					cal.set(Calendar.MONTH, 0);
					cal.set(Calendar.DAY_OF_MONTH, 0);
					
					Calendar calNext = Calendar.getInstance();
					calNext.set(Calendar.YEAR, year +1);
					calNext.set(Calendar.MONTH, 0);
					calNext.set(Calendar.DAY_OF_MONTH, 0);
					
					
					pst = conn.prepareStatement(SQL);
					Date date = new Date(cal.getTimeInMillis());
					Date dateNext = new Date(calNext.getTimeInMillis());
					pst.setInt(1, ouletNumber);
					pst.setDate(2, date);
					pst.setDate(3, dateNext);
					rs = pst.executeQuery();
					StringBuffer buffer = new StringBuffer();
					while(rs.next()) {
						
						
						
						buffer.append("OUTLET_NUMBER: " + rs.getInt("OUTLET_NUMBER")+"\n" );
						buffer.append("EMP_NUMBER: " + rs.getInt("EMP_NUMBER")+"\n" );
						buffer.append("CUSTOMER_ID: " + rs.getInt("CUSTOMER_ID")+"\n" );
						buffer.append("PRODUCT_CODE: " + rs.getInt("PRODUCT_CODE")+"\n" );
						buffer.append("SALE_DATE: " + rs.getDate("SALE_DATE")+"\n" );
						buffer.append("SALE_TIME: " + rs.getTime("SALE_TIME") +"\n");
						buffer.append("quantity: " + rs.getInt("quantity")+"\n" );
						buffer.append("--------------------\n" );
						
						message = buffer.toString();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					message = "SALES NOT FOUND"+e;
				}
				return message;
				
			}
			

		public String SEReport(Connection conn, int empNumber) {
			
			PreparedStatement pst = null;
			ResultSet rs;
			
			String SQL = "SELECT * FROM SALES WHERE EMP_NUMBER = ? ";
			
			try {
				
				pst = conn.prepareStatement(SQL);
				
				pst.setInt(1, empNumber);
				
				rs = pst.executeQuery();
				StringBuffer buffer = new StringBuffer();
				while(rs.next()) {
					
					
					
					buffer.append("OUTLET_NUMBER: " + rs.getInt("OUTLET_NUMBER")+"\n" );
					buffer.append("EMP_NUMBER: " + rs.getInt("EMP_NUMBER")+"\n" );
					buffer.append("CUSTOMER_ID: " + rs.getInt("CUSTOMER_ID")+"\n" );
					buffer.append("PRODUCT_CODE: " + rs.getInt("PRODUCT_CODE")+"\n" );
					buffer.append("SALE_DATE: " + rs.getDate("SALE_DATE")+"\n" );
					buffer.append("SALE_TIME: " + rs.getTime("SALE_TIME") +"\n");
					buffer.append("quantity: " + rs.getInt("quantity")+"\n" );
					buffer.append("--------------------\n" );
					
					message = buffer.toString();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				message = "SALES NOT FOUND"+e;
			}
			return message;
			
		}
	
		public String topProducts(Connection conn) {
			PreparedStatement pst = null;
			ResultSet rs;
			
			String SQL = "SELECT  SALES.PRODUCT_CODE, PRODUCT.artist, PRODUCT.title "
					+ "FROM SALES  INNER JOIN PRODUCT ON SALES.PRODUCT_CODE = PRODUCT.PRODUCT_CODE "
					+ "GROUP BY PRODUCT_CODE ORDER BY SUM(SALES.PRODUCT_CODE) DESC LIMIT 10";
			try {
				
				pst = conn.prepareStatement(SQL);
				
				
				
				rs = pst.executeQuery();
				StringBuffer buffer = new StringBuffer();
				while(rs.next()) {
		
					buffer.append("PRODUCT_CODE: " + rs.getInt("PRODUCT_CODE")+"\n" );
					buffer.append("Artist: " + rs.getString("artist")+"\n" );
					buffer.append("Title: " + rs.getString("title") +"\n");
					buffer.append("--------------------\n" );
					
					message = buffer.toString();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				message = "SALES NOT FOUND"+e;
			}
			return message;
			
		}
	
	
	/*
	 * public int quantityAvaliable() { InventoryDAO idao = new InventoryDAO();
	 * return idao.actualQuant; }
	 * 
	 * 
	 * public int getRows(Connection conn, Sale sale, String empName) {
	 * 
	 * PreparedStatement pst = null;
	 * 
	 * String SQL = "SELECT * FROM SALE WHERE emp_name = ?"; ResultSet rs; int nRows
	 * = 0;
	 * 
	 * try { pst = conn.prepareStatement(SQL); pst.setString(1, empName);
	 * 
	 * rs = pst.executeQuery(); rs.last(); nRows = rs.getRow(); pst.close(); } catch
	 * (SQLException e1) { // TODO Auto-generated catch block e1.getMessage(); }
	 * return nRows; }
	 * 
	 * public int getRowsById(Connection conn, Sale sale, int empNumber) {
	 * 
	 * PreparedStatement pst = null;
	 * 
	 * String SQL = "SELECT * FROM SALE WHERE EMP_NUMBER = ?"; ResultSet rs; int
	 * nRows = 0;
	 * 
	 * try { pst = conn.prepareStatement(SQL); pst.setInt(1, empNumber);
	 * 
	 * rs = pst.executeQuery(); rs.last(); nRows = rs.getRow(); pst.close(); } catch
	 * (SQLException e1) { // TODO Auto-generated catch block e1.getMessage(); }
	 * return nRows; }
	 * 
	 * 
	 * public String modifySale(Connection conn, Sale sale, String empName){
	 * 
	 * PreparedStatement pst = null;
	 * 
	 * 
	 * String SQL =
	 * "UPDATE SALE SET OUTLET_NUMBER = ?, emp_name = ? WHERE emp_name = ?";
	 * 
	 * try { pst = conn.prepareStatement(SQL); pst.setInt(1,
	 * sale.getOutletNumber()); pst.setString(2, sale.getEmpName());
	 * pst.setString(3, empName); message = "SALE MODIFIED CORRECTY ";
	 * pst.execute(); pst.close();
	 * 
	 * 
	 * }catch (SQLException e) { // TODO Auto-generated catch block
	 * System.err.println("SALE NOT MODIFIED CORRECTLY" + e); }
	 * 
	 * return message; }
	 * 
	 * 
	 * public String dropSale(Connection conn, int empNumber){
	 * 
	 * PreparedStatement pst = null; String SQL =
	 * "DELETE FROM SALE WHERE EMP_NUMBER = ?"; try { pst =
	 * conn.prepareStatement(SQL); pst.setInt(1, empNumber); message =
	 * "SALE DROPPED CORRECTLY"; pst.execute(); pst.close(); } catch (SQLException
	 * e) { // TODO Auto-generated catch block message =
	 * "SALE NOT DROPPED CORRECTLY" + e.getMessage(); }
	 * 
	 * return message; }
	 * 
	 * public void listOutlet(){
	 * 
	 * }
	 */

}
