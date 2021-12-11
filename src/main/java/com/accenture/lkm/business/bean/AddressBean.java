package com.accenture.lkm.business.bean;




public class AddressBean {
	
	private String city;
    
	   
   private String shopname;
   
   public AddressBean()
   {
   	
   }

public AddressBean(String city, String shopname) {
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
