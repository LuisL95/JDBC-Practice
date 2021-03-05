package com.model;

public class Product {
	
	private int productCode;
	private String artist;
	private String title;
	private double cost;
	private double salePrice;
	
	public Product(){
		
	}
	
	public Product(int productCode, String artist, String title, double cost, double salePrice) {
		super();
		this.productCode = productCode;
		this.artist = artist;
		this.title = title;
		this.cost = cost;
		this.salePrice = salePrice;
	}

	public int getProductCode() {
		return productCode;
	}


	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", artist=" + artist + ", title=" + title + ", cost=" + cost
				+ ", salePrice=" + salePrice + "]";
	}
	
	
	
	

}
