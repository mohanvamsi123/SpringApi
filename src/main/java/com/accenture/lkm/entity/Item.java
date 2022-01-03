package com.accenture.lkm.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.lang.*;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

import javax.persistence.UniqueConstraint;


@Entity(name="Item")
@Table(uniqueConstraints= {@UniqueConstraint(columnNames= {"Item_Name"})})

public class Item {
	
	
	@Id
	@Column(name="Item_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Item_Id;
	@Column(name = "Item_Name", nullable = false)
    private String Item_Name;
	@Column(columnDefinition="boolean default True")
    private boolean Item_Status;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	 private Date CreatedDate;

	
	
	
	public long getItem_Id() {
		return Item_Id;
	}
	public void setItem_Id(long item_Id) {
		Item_Id = item_Id;
	}
	public String getItem_Name() {
		return Item_Name;
	}
	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}
	public boolean isItem_Status() {
		return Item_Status;
	}
	public void setItem_Status(boolean item_Status) {
		Item_Status = item_Status;
	}
	public Date getCreatedDate()
    {
   return CreatedDate;
}

public void setCreatedDate(Date CreatedDate)
{
this.CreatedDate=CreatedDate;
} 

	

	
	
	public Item(long item_Id, String item_Name, boolean item_Status,Date CreatedDate) {
		super();
		
		Item_Id = item_Id;
		Item_Name = item_Name;
		Item_Status = item_Status;
		this.CreatedDate=CreatedDate;
		
		
	}
	
	public Item()
	{
		
	}
	
	
	
	
	

}
	