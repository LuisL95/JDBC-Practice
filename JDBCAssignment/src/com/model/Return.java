package com.model;

import java.sql.Date;
import java.sql.Time;

public class Return {
	
	private int outletNumber;
	private int productCode;
	private int costumerId;	
	private Date returnDate;
	private Time returnTime;
	private int quantity;
	private String reason;
	
	
	public Return (){
		
	}
	
	public Return(int outletNumber, int productCode, int costumerId, Date returnDate, Time returnTime, int quantity, String reason) {
		super();
		this.outletNumber = outletNumber;
		this.productCode = productCode;
		this.costumerId = costumerId;
		this.returnDate = returnDate;
		this.returnTime = returnTime;
		this.quantity = quantity;
		this.reason = reason;
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

	public int getCostumerId() {
		return costumerId;
	}

	public void setCostumerId(int costumerId) {
		this.costumerId = costumerId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Time getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Time returnTime) {
		this.returnTime = returnTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Return [outletNumber=" + outletNumber + ", productCode=" + productCode + ", costumerId=" + costumerId
				+ ", returnDate=" + returnDate + ", returnTime=" + returnTime + ", quantity=" + quantity + "]";
	}
	
	
	
	

}
