package com.accenture.lkm.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;



@Entity(name="Cust_Payment")

public class Cust_Payment {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "Amount")
	private long Amount;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "created_at",updatable=true)
    @Temporal(TIMESTAMP)
    private Date transaction_date;
	

    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "Person_id", referencedColumnName = "U_id") 
    private Person person;
	
	
	public long getId() {
		return Id;
	}



	public void setId(long id) {
		Id = id;
	}



	public long getAmount() {
		return Amount;
	}



	public void setAmount(long amount) {
		Amount = amount;
	}



	public Date getTransaction_date() {
		return transaction_date;
	}



	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	/*public Cust_Payment(long id, long amount, Date transaction_date, Person person) {
		super();
		Id = id;
		Amount = amount;
		this.transaction_date = transaction_date;
		this.person = person;
	}



	public Cust_Payment() {
		// TODO Auto-generated constructor stub
	}

	*/

	
   

    
   
	
	

}
