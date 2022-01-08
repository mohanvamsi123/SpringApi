package com.accenture.lkm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.ItemBean;
import com.accenture.lkm.entity.Item;

@Service
public interface ItemService {
	
	

	List<Item> getItems();
	 
	void PostItems(Item p);

	

	List<Item> getItemsByStatus(String status);

	
       String Update(long id);
	

	//List<ItemBean> getItemsByStatus(String status);

	
	
	

}
