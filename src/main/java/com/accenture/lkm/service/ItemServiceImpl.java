package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.accenture.lkm.business.bean.ItemBean;
import com.accenture.lkm.business.bean.Personbean;
import com.accenture.lkm.dao.ItemDAO;
import com.accenture.lkm.entity.Item;
import com.accenture.lkm.entity.Person;

@Service
public class ItemServiceImpl implements ItemService {
	
	
	@Autowired
	private ItemDAO i;

	@Override
	public List<Item> getItems() {
		
		
		List<Item> PersonListEntity= i.findAll();
	/*	List<ItemBean>PersonListModel=new ArrayList<ItemBean>();
		
		for(Item ue: PersonListEntity) {
			ItemBean b=new ItemBean();
			BeanUtils.copyProperties(ue, b);
			PersonListModel.add(b);
	} */
		return PersonListEntity;

	
	}

	

	@Override
	public void PostItems(Item p) {
	p.setcreatedAt(new Date());
		
		
	i.save(p);


		
		
		
	}
	
	
	




	public List<Item> getItemsByStatus(String status) {
		List<Item> PersonListEntity;
		
		if(status.equals("active"))
		{
			PersonListEntity= i.Find(true);
		}
		
		else 
		{
			PersonListEntity= i.Find(false);
		}
		
			
			
		
	
	/*	List<ItemBean>PersonListModel=new ArrayList<ItemBean>();
		
		for(Item ue: PersonListEntity) {
			ItemBean b=new ItemBean();
			BeanUtils.copyProperties(ue, b);
			PersonListModel.add(b);
	} */
		return PersonListEntity;
	}

	public String Update(long id)
	{
		System.out.print("up");
    
	  List<Item> PersonListEntity= i.findAll();
      Item k=new Item();
	  for(Item ue: PersonListEntity) {
			if(ue.getItem_Id()==id)
			{ 
				 k=ue;
				break;
			}
	  }
      System.out.print("up");
	  //i.delete(id);
      System.out.print("down");
	   if(k.isItem_Status())
	   {
	   k.setItem_Status(false);
	   k.setUpdatedAt(new Date());
	   }
	   else
	   {k.setItem_Status(true);
	   k.setUpdatedAt(new Date());
	   }
		
	   i.save(k);
		
	  
	
		return "yes";
	
	}

	




	}



	
	
	
	
	
	
	
	


