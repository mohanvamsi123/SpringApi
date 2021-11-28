package com.accenture.lkm.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity(name="Person")
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"first_name","phone_no","Last_name","Altphone_no"})})
public class Person {
	
	
	@Id
	@Column(name="U_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long U_id;
    
	
   @Column(name = "first_name", nullable = false)
   private String firstName;
    
	
   @Column(name = "last_name", nullable = false)
   private String lastName;
   
   @Column(name = "phone_no",length=10,nullable = false)
   private long phone_no;
   
   @Column(name = "Altphone_no",length=10,nullable = false)
   private long Altphone_no;
   
  @Embedded
   private Address address;
  
  public Person()
  {
	  
  }

public Person(Long u_id, String firstName, String lastName, long phone_no, long altphone_no, Address address) {
	super();
	U_id = u_id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone_no = phone_no;
	Altphone_no = altphone_no;
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

public long getAltphone_no() {
	return Altphone_no;
}

public void setAltphone_no(long altphone_no) {
	Altphone_no = altphone_no;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}
}


