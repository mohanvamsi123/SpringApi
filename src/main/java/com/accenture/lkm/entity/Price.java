package com.accenture.lkm.entity;
import java.util.Date;

//import org.springframework.data.annotation.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import static javax.persistence.TemporalType.TIMESTAMP;

import org.springframework.format.annotation.DateTimeFormat;
@Entity(name="Price")
@Table()
public class Price {



	
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(name = "Item_Price", nullable = false)
    private double Item_Price;
    @Column(name = "Item_Qty", nullable = false)
    private int Item_Qty;
    @Column(name = "Total_Price", nullable = false)
    private long Total_Price;
    

    
    public void setTotal_Price(long total_Price) {
		Total_Price = total_Price;
	}
	public long getTotal_Price() {
		return Total_Price;
	}
	public void setTotal_Price(int total_Price) {
		Total_Price = total_Price;
	}

	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "Item_Id", referencedColumnName = "Item_Id") 
    
    private Item item;
    
    //@DateTimeFormat(pattern="yyyy-MM-dd")
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TIMESTAMP)
    @Column(name = "created_at",updatable=true)
    private Date createdAt;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "Person_id", referencedColumnName = "U_id") 
    private Person person;



   /* public Price(long Id,double Item_Price,int Item_Qty,Person person,Date createdAt,Item item)
    {
        
        this.Id=Id;
        this.Item_Price=Item_Price;
        this.item=item;
        this.createdAt=createdAt;
        this.Item_Qty=Item_Qty;
        this.person=person;

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
public Person getPerson()   
{  
return person;  
}  
public void setPerson(Person person)   
{  
this.person = person;  
}  
 public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

