package com.accenture.lkm.entity;

import java.util.Date;

public class TransactionsDTO {
	
	
	private long Amount;
    private Date transaction_date;
    private long personId;
    private  String status;
	
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
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long person) {
		this.personId = person;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}




}
