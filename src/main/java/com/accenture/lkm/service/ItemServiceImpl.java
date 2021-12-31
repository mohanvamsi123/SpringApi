package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<ItemBean> getItems() {
		
		
		List<Item> PersonListEntity= i.findAll();
		List<ItemBean>PersonListModel=new ArrayList<ItemBean>();
		
		for(Item ue: PersonListEntity) {
			ItemBean b=new ItemBean();
			BeanUtils.copyProperties(ue, b);
			PersonListModel.add(b);
	}
		return PersonListModel;

	
	}

	

	@Override
	public void PostItems(Item p) {
		
		
		
	i.save(p);
		
		
		
	}
	
	
	




	public List<ItemBean> getItemsByStatus(String status) {
		List<Item> PersonListEntity;
		
		if(status.equals("active"))
		{
			PersonListEntity= i.Find(true);
		}
		
		else 
		{
			PersonListEntity= i.Find(false);
		}
		
			
			
		
	
		List<ItemBean>PersonListModel=new ArrayList<ItemBean>();
		
		for(Item ue: PersonListEntity) {
			ItemBean b=new ItemBean();
			BeanUtils.copyProperties(ue, b);
			PersonListModel.add(b);
	}
		return PersonListModel;
	}



	
	
	
	
	
	
	
	

}