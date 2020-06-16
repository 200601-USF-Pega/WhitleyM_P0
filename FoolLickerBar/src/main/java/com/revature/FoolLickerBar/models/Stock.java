package com.revature.FoolLickerBar.models;

public class Stock {

	private String alcoholType;
	private String alcoholName;
	private int alcoholContent;
	private int alcoholPrice;
	
	public Stock(String alcoholType, String alcoholName, int alcoholContent, int alcoholPrice) {
		this.alcoholType = alcoholType;
		this.alcoholName = alcoholName;
		this.alcoholContent = alcoholContent;
		this.alcoholPrice = alcoholPrice;
	}
	
	public String getAlcoholType() {
		return alcoholType;
	}

	public void setAlcoholType(String alcoholType) {
		this.alcoholType = alcoholType;
	}

	public String getAlcoholName() {
		return alcoholName;
	}

	public void setAlcoholName(String alcoholName) {
		this.alcoholName = alcoholName;
	}

	public int getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(int alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public int getAlcoholPrice() {
		return alcoholPrice;
	}

	public void setAlcoholPrice(int alcoholPrice) {
		this.alcoholPrice = alcoholPrice;
	}

}
