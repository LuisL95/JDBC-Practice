package com.model;

public class Outlet {

	private int outletNumber;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private int phone;
	
	public Outlet() {
		
	}
	
	public Outlet ( String name, String address,String city, String state, String zip, int phone ){
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	public int getOutletNumber() {
		return outletNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Outlet [outletNumber=" + outletNumber +", name=  " + name + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", phone=" + phone + "]";
	}

	
	
	
	
}
