package com.accenture.lkm.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
public class Address {
	 private int houseNumber;
	     
	   
	    
	     
	    
	    private String city;
	     
	   
	    private String shopname;
	     
	   
	    
public Address()
{
	
}



public Address(int houseNumber, String city, String shopname) {
	super();
	this.houseNumber = houseNumber;
	this.city = city;
	this.shopname = shopname;
}



public int getHouseNumber() {
	return houseNumber;
}



public void setHouseNumber(int houseNumber) {
	this.houseNumber = houseNumber;
}



public String getCity() {
	return city;
}



public void setCity(String city) {
	this.city = city;
}



public String getShopname() {
	return shopname;
}



public void setShopname(String shopname) {
	this.shopname = shopname;
}


		
