package com.accenture.lkm.business.bean;



import com.accenture.lkm.entity.Address;

public class Personbean {

	private long U_id;
    
	
	   
	private String firstName;
	    
		

	   private String lastName;
	   
	
	   private long phone_no;
	   
	   
	
	   private Address address;
	   
	   
	   public Personbean()
	   {
	 	  
		   
	   }


	public Personbean(Long u_id, String firstName, String lastName, long phone_no, Address address) {
		super();
		U_id = u_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone_no = phone_no;
		this.address = address;
	}


	public Long getU_id() {
		return U_id;
	}


	public void setU_id(Long u_id) {
		U_id = u_id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public long getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	   
}
