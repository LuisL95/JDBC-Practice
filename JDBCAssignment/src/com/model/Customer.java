package com.model;

public class Customer {


	private int customerId;
	private String customerName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private int phone;
	
	public Customer(){
		
	}
	
	public Customer(int customerId, String customerName, String address, String city, String state, String zip,
			int phone) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + "]";
	}
	
	
	
	
	
}
