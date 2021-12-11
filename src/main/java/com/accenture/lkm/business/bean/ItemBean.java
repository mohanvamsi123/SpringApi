package com.accenture.lkm.business.bean;

import java.util.Date;

public class ItemBean {
	
	
	private long Item_Id;
     private String Item_Name;
     private boolean Item_Status;

	public ItemBean(long item_Id, String item_Name, boolean item_Status) {
		super();
		Item_Id = item_Id;
		Item_Name = item_Name;
		Item_Status = item_Status;
	}
		public ItemBean()
		{
			
		}
		
	
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

     
     
     
}
     
    