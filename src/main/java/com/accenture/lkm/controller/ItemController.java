package com.accenture.lkm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.ItemBean;
import com.accenture.lkm.business.bean.Personbean;
import com.accenture.lkm.dao.ItemDAO;
import com.accenture.lkm.entity.Item;
import com.accenture.lkm.entity.Person;
import com.accenture.lkm.service.ItemService;


@RestController
@RequestMapping("/item/controller")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value="/getDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemBean>> getdetails() 
	{
		if((itemService.getItems()).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<ItemBean>>(HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<List<ItemBean>>(itemService.getItems(), HttpStatus.FOUND);
		}		
	}	
	
	
	@GetMapping(value="/getDetails/{status}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemBean>> getdetails(@PathVariable("status") String status) 
	{
		if((itemService.getItemsByStatus(status)).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<ItemBean>>(HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<List<ItemBean>>(itemService.getItemsByStatus(status), HttpStatus.FOUND);
		}		
	}	

	
	


	@PostMapping(value = "/postDetails")
	public String postdetails(@RequestBody Item p){
		

	    itemService.PostItems(p);
		return "sucess";
		
		
		
		
	}
	
	@PutMapping(value = "/putDetails")
	public String  putdetails(@RequestBody Item p){
		 
		 itemService.PostItems(p);
		 return "success";
		
			
	

	
	}

}