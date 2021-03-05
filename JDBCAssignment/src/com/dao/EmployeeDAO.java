package com.dao;

import java.sql.*;

import com.model.Employee;


public class EmployeeDAO {

	private String message;
	
	public String addEmployee(Connection conn, Employee employee){
		
		PreparedStatement pst = null;
		
		String SQL  = "INSERT INTO EMPLOYEE (OUTLET_NUMBER, emp_name) VALUES(?,?)";
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, employee.getOutletNumber());
			pst.setString(2, employee.getEmpName());
			message = "NEW EMPLOYEE ADDED CORRECTY ";
			pst.execute();
			pst.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("NEW EMPLOYEE NOT ADDED CORRECTLY" + e);
		}
		return message;
	}
	
	
	
	public int getRows(Connection conn, String empName) {
		
		PreparedStatement pst = null;
		
		String SQL = "SELECT * FROM EMPLOYEE WHERE emp_name = ?";
		ResultSet rs; 
		int nRows = 0;
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setString(1, empName);
			
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
	
	public int getRowsById(Connection conn, int empNumber) {
			
			PreparedStatement pst = null;
			
			String SQL = "SELECT * FROM EMPLOYEE WHERE EMP_NUMBER = ?";
			ResultSet rs; 
			int nRows = 0;
			
			try {
				pst = conn.prepareStatement(SQL);
				pst.setInt(1, empNumber);
				
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
	
	public int getEmpOutlet(Connection conn,  int empNumber) {
		int empOutlet = 0;
		PreparedStatement pst = null;
		
		String SQL = "SELECT * FROM EMPLOYEE WHERE EMP_NUMBER = ?";
		ResultSet rs; 
		
		
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, empNumber);
			
			rs = pst.executeQuery();
			rs.last();
			 empOutlet =rs.getInt("OUTLET_NUMBER");
			
			pst.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		return empOutlet;
	}
	
	
	public String modifyEmployee(Connection conn, Employee employee, String empName){
		
		PreparedStatement pst = null;
		

		String SQL  = "UPDATE EMPLOYEE SET OUTLET_NUMBER = ?, emp_name = ? WHERE emp_name = ?";
				
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, employee.getOutletNumber());
			pst.setString(2, employee.getEmpName());
			pst.setString(3, empName);
			message = "EMPLOYEE MODIFIED CORRECTY ";
			pst.execute();
			pst.close();
				
					
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			System.err.println("EMPLOYEE NOT MODIFIED CORRECTLY" + e);
		}
				
			return message;
	}
	
	
	public String dropEmployee(Connection conn, int empNumber){
		
		PreparedStatement pst = null;
		String SQL = "DELETE FROM EMPLOYEE WHERE EMP_NUMBER = ?";
		try {
			pst = conn.prepareStatement(SQL);
			pst.setInt(1, empNumber);
			message = "EMPLOYEE DROPPED CORRECTLY";
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "EMPLOYEE NOT DROPPED CORRECTLY" + e.getMessage();
		}
		
		return message;
	}
	
	public void listOutlet(){
		
	}
}
