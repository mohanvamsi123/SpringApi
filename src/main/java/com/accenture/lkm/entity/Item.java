package com.accenture.lkm.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	
	public Item(long item_Id, String item_Name, boolean item_Status) {
		super();
		
		Item_Id = item_Id;
		Item_Name = item_Name;
		Item_Status = item_Status;
		
		
	}
	
	public Item()
	{
		
	}
	
	
	
	
	

}
	