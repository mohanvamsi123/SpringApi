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

    
}