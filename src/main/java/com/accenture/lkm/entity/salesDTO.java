package com.accenture.lkm.entity;
import java.util.*;

public class salesDTO
{


    private long id;
    private long p_id;
    private Date d;
    private String p_name;
    private long i_id;
    private String i_name;
    private int qty;
    private double price;


    public salesDTO(long id,long p_id,Date d,String p_name,long i_id, String i_name,int qty,double price)
    {
        this.id=id;
        this.p_id=p_id;
        this.d=d;
        this.p_name=p_name;
        this.i_id=i_id;
        this.i_name=i_name;
        this.qty=qty;
        this.price=price;

    }

public long getId()   
{  
return id;  
}  
public void setId(long id)   
{  
this.id = id;  
}  
public double getprice()   
{  
return price;  
}  
public void setprice(double price)   
{  
this.price = price;  
}  
 public long getp_id()   
{  
return p_id;  
}  
public void setp_id(long p_id)   
{  
this.p_id = p_id;  
}  
public long getp_name()   
{  
return p_name;  
}  
public void setp_name(long p_name)   
{  
this.p_name = p_name;  
}  

public int getqty()   
{  
return qty;  
}  
public void setItem_Qty(int qty)   
{  
this.qty = qty;  
} 
public i_id geti_id()   
{  
return i_id;  
}  
public void seti_id(long i_id)   
{  
this.i_id = i_id;  
}  

public i_name geti_name()   
{  
return i_name;  
}  
public void seti_name(String i_name)   
{  
this.i_name = i_name;  
}  
 public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    
}