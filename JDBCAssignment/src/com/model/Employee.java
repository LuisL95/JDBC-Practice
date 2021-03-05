package com.model;

public class Employee {

	private int empId;
	private int OutletNumber;
	private String empName;
	
	public Employee() {
		
	}
	
	public Employee(int empId, int outletNumber, String empName) {
		this.empId = empId;
		OutletNumber = outletNumber;
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public int getOutletNumber() {
		return OutletNumber;
	}

	public void setOutletNumber(int outletNumber) {
		OutletNumber = outletNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", OutletNumber=" + OutletNumber + ", empName=" + empName + "]";
	}
	
	
	
	
	
}
