package com.model;

public class Inventory {
	
	private int outletNumber;
	private int productCode;
	private int quantity;
	
	public Inventory() {
		
	}
	
	public Inventory(int outletNumber, int productCode, int quantity) {
		
		this.outletNumber = outletNumber;
		this.productCode = productCode;
		this.quantity = quantity;
	}

	public int getOutletNumber() {
		return outletNumber;
	}

	public void setOutletNumber(int outletNumber) {
		this.outletNumber = outletNumber;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public int addQuantity(int QuantAdded){
		quantity = quantity + QuantAdded;
		
		return quantity;
		
	}

	@Override
	public String toString() {
		return "Inventory [outletNumber=" + outletNumber + ", productCode=" + productCode + ", quantity=" + quantity
				+ "]";
	}
	
	
	
	


}
