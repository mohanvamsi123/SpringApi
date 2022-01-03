package com.accenture.lkm.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
public class Address {
	
	     private String city;
	     private String shopname;
	     
	   
	    
public Address()
{
	
}



public Address(String city, String shopname) {
	super();
	this.city = city;
	this.shopname = shopname;
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



}