package com.accenture.lkm.entity;

import javax.persistence.*;  

@Entity

public class Price {
	
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(name = "Item_Price", nullable = false)
    private double Item_Price;
    @Column(name = "Item_Qty", nullable = false)
    private int Item_Qty;
    

    
    @ManyToOne(fetch=FetchType.LAZY)  
    private Item item;

public int getId()   
{  
return Id;  
}  
public void setId(int id)   
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
public Item getItem()   
{  
return item;  
}  


public void setItem(Item item)   
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
  

	
	
	
	

	
	

	
	
}