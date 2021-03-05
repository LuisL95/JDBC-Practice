package com.model;

import java.sql.*;


public class Sale {

	private int outletNumber;
	private int empNumber;
	private int costumerId;
	private int productCode;
	private Date saleDate;
	private Time saleTime;
	private int quantity;
	
	public Sale(){
		
	}

	public Sale(int outletNumber, int empNumber, int costumerId, int productCode, Date date, Time time, int quantity) {
		
		this.outletNumber = outletNumber;
		this.empNumber = empNumber;
		this.costumerId = costumerId;
		this.productCode = productCode;
		this.saleDate = date;
		this.saleTime = time;
		this.quantity = quantity;
	}

	public int getOutletNumber() {
		return outletNumber;
	}

	public void setOutletNumber(int outletNumber) {
		this.outletNumber = outletNumber;
	}

	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public int getCostumerId() {
		return costumerId;
	}

	public void setCostumerId(int costumerId) {
		this.costumerId = costumerId;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public Date getSaleDate() {
		return saleDate;
	}
	
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}


	public Time getSaleTime() {
		return saleTime;
	}
	
	public void setSaleTime(Time saleTime) {
		this.saleTime = saleTime;
	}


	public int getQuantity() {
		return quantity;
		
		
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Sale [outletNumber=" + outletNumber + ", empNumber=" + empNumber + ", costumerId=" + costumerId
				+ ", productCode=" + productCode + ", saleDate=" + saleDate + ", saleTime=" + saleTime + ", quantity="
				+ quantity + "]";
	}
	
	
}
