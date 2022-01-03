package com.accenture.lkm.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;


@Entity(name="Person")
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"first_name","phone_no"})})
public class Person {
	
	
	@Id
	@Column(name="U_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long U_id;
    
	
   @Column(name = "first_name", nullable = true)
   private String firstName;
    
	
   
   
   @Column(name = "phone_no",length=10,nullable = false)
   private long phone_no;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "Created_Date",nullable=false)
   private Date CreatedDate;

    @PrePersist
    private void onCreate(){
    CreatedDate=new Date();
     }
   
   
  @Embedded
   private Address address;
  public Person()
  {
	  
  }

public Person(long u_id, String firstName, long phone_no, Date CreatedDate, Address address) {
	super();
	U_id = u_id;
	this.firstName = firstName;
	this.phone_no = phone_no;
	this.CreatedDate=CreatedDate;
	this.address = address;
}

public long getU_id() {
	return U_id;
}

public void setU_id(long u_id) {
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
