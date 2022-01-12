package com.accenture.lkm.entity;




public class PriceDTO {


    private long Id;
	private double Item_Price;
    private int Item_Qty;
    private long item;
    private Date createdAt;
    private long person;



   /* public Price(long Id,double Item_Price,int Item_Qty)
    {
        
        this.Id=Id;
        this.Item_Price=Item_Price;
        this.Item_Qty=Item_Qty;

    }
    public Price()
    {
        
    } */

public long getId()   
{  
return Id;  
}  
public void setId(long id)   
{  
Id = id;  
}  
public double getItem_Price()   
{  
return Item_Price;  
}  
public void setItem_Price(double Item_price)   
{  
Item_Price = Item_price;  
}  
 public long getItem()   
{  
return item;  
}  
public void setItem(long item)   
{  
this.item = item;  
}  

public int getItem_Qty()   
{  
return Item_Qty;  
}  
public void setItem_Qty(int Item_Qty)   
{  
this.Item_Qty = Item_Qty;  
} 
public long getPerson()   
{  
return person;  
}  
public void setPerson(long person)   
{  
this.person = person;  
}  
public Date getCreatedAt() 
{
return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}