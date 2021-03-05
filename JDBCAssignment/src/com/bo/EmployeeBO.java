package com.bo;

import java.sql.Connection;

import com.dao.EmployeeDAO;
import com.db.ConnectDB;
import com.model.Employee;

public class EmployeeBO {
	
	private String message = " ";
	private EmployeeDAO odao = new EmployeeDAO();
	
	public String addEmployee(Employee employee) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.addEmployee(conn, employee);
			
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
	
	public int getRows( String employeeName) {
			Connection conn = ConnectDB.getConnection();
			int result = odao.getRows(conn,  employeeName);
			return result;
	}
	
	public int getRowsById( int employeeNum) {
		Connection conn = ConnectDB.getConnection();
		int result = odao.getRowsById(conn,  employeeNum);
		return result;
}
	public int getEmpOutlet( int employeeNum) {
		Connection conn = ConnectDB.getConnection();
		int result = odao.getEmpOutlet(conn, employeeNum);
		return result;
	}
	
	public String modifyEmployee(Employee employee, String employeeName) {
			
			Connection conn = ConnectDB.getConnection();
			try {
				
				message = odao.modifyEmployee(conn, employee, employeeName);
				
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
	
	
	public String dropEmployee(int employeeNumber) {
		
		Connection conn = ConnectDB.getConnection();
		try {
			
			message = odao.dropEmployee(conn, employeeNumber);
			
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
