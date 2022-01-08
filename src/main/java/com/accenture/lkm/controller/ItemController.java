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

@CrossOrigin
@RestController
@RequestMapping("/item/controller")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value="/getDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Item>> getdetails() 
	{
		if((itemService.getItems()).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<List<Item>>(itemService.getItems(), HttpStatus.OK);
		}		
	}	
	
	
	@GetMapping(value="/getDetails/{status}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Item>> getdetails(@PathVariable("status") String status) 
	{
		if((itemService.getItemsByStatus(status)).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
			
		}else {
			return new ResponseEntity<List<Item>>(itemService.getItemsByStatus(status), HttpStatus.OK);
		}		
	}	

	
	


	@PostMapping(value = "/postDetails")
	public String postdetails(@RequestBody Item p){
		

	    itemService.PostItems(p);
	    return "{\"response\":\"successfully added item.\"}";
		
		
		
		
	}
	
			
	

	
	
	@PutMapping(value = "/putDetails/{id}")
	public String  putdetails(@PathVariable(value = "id") long id){
		 System.out.print("entr");
	String d=itemService.Update(id);



	if(d=="yes")
	{
	
  return "{\"response\":\"successfully updated item,.\"}";
  }

	
	else {
		return "{\"response\":\" sorry item not available,.\"}";
		}
	}
}
