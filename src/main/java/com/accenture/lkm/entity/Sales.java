public class Sales
{


    public Sales()
    {

    }

    private double Item_Price;
    private int Item_Qty;
    private long item;
    public String Item_Name;
    public String Person_Name;
    private Date createdAt;
    private long person;



public String getPerson_Name() {
	return Person_Name;
}

public void setPerson_Name(String Person_Name) {
	this.Person_Name = Person_Name;
}

public String getItem_Name() {
		return Item_Name;
	}
	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
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





}