package com.accenture.lkm.entity;



import java.util.Date;


public class Cust_PaymentDTO {
	
	private long Id;
	private long Amount;
    private Date transaction_date;
    private long person;


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


	public long getPerson() {
		return person;
	}


	public void setPerson(long person) {
		this.person = person;
	}


/*	public Cust_PaymentDTO(long id, long amount, Date transaction_date, long person) {
		super();
		Id = id;
		Amount = amount;
		this.transaction_date = transaction_date;
		this.person = person;
	}
*/
}
