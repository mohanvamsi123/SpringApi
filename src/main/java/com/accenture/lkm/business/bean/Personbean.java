package com.accenture.lkm.business.bean;



import com.accenture.lkm.entity.Address;
import java.util.Date;

public class Personbean {

	private long U_id;
    
	
	   
	private String firstName;
	    
		

	   
	
	   private long phone_no;
	   
	   
	 private Date CreatedDate;
	   private Address address;


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


	


	public long getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public Date getCreatedDate()
{
return CreatedDate;
}

public void setCreatedDate(Date CreatedDate)
{
this.CreatedDate=CreatedDate;
}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	   
}

	   
	   
	   public Personbean()
	   {
	 	  
		   
	   }


	public Personbean(Long u_id, String firstName, long phone_no,Date CreatedDate, Address address) {
		super();
		U_id = u_id;
		this.firstName = firstName;
		this.phone_no = phone_no;
		this.CreatedDate=CreatedDate;
		this.address = address;
	}


	