package com.accenture.lkm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.ItemBean;
import com.accenture.lkm.entity.Item;

@Service
public interface ItemService {
	
	

	List<ItemBean> getItems();
	 
	void PostItems(Item p);

	

	List<ItemBean> getItemsByStatus(String status);

	

	

	//List<ItemBean> getItemsByStatus(String status);

	
	
	

}
