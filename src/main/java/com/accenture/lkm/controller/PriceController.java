package com.accenture.lkm.controller;
import org.springframework.data.domain.Sort;



import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.lkm.entity.*;
import com.accenture.lkm.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/price/controller")
public class PriceController
{
  
     
	@Autowired
	private PriceDAO v;
	@Autowired
    private ItemDAO g;
   
	@Autowired
	private EmployeeDAO h;


    @GetMapping(value="/getDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Price>> getdetails() 
	{
	/*	if((itemService.getItems()).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<Price>>(HttpStatus.NO_CONTENT);
			
		}else { */
			return new ResponseEntity<List<Price>>(v.findAll(), HttpStatus.OK);
		
	}	

    @GetMapping(value="/getDetails/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<salesDTO> getdetails(@PathVariable(value = "id") long id) 
	{
        

	/*	if((itemService.getItems()).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
			
		}else {

			return new ResponseEntity<List<Item>>(itemService.getItems(), HttpStatus.OK);
        } */
        List<Price> PersonListEntity= v.findAll(new Sort(Sort.Direction.ASC, "createdAt"));
        List<salesDTO> k=new ArrayList<salesDTO>();
	    for(Price ue: PersonListEntity) {
			if(ue.getPerson().getU_id() ==id)
			{ 
				salesDTO v=new salesDTO(ue.getId(),ue.getPerson().getU_id(),ue.getCreatedAt(),ue.getPerson().getFirstName(),ue.getItem().getItem_Id(),ue.getItem().getItem_Name(),ue.getItem_Qty(),ue.getItem_Price());
				k.add(v);
			}
	  }


        
        return k;
       // return new ResponseEntity<List<String,String>>(pname,iname, HttpStatus.OK);
     
	}	


	@GetMapping(value="/getDetails/{id}/{date1}/{date2}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<salesDTO> getdetails(@PathVariable(value = "date1") String date1,@PathVariable(value = "date2") String date2,@PathVariable(value = "id") long id ) throws Exception
	{
	/*	if((itemService.getItems()).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<Price>>(HttpStatus.NO_CONTENT);
			
		}else { */
        
		Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
		//Date datex2=;
		Date endDate=new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date2).getTime()+(86400000));
		System.out.println(startDate);
		System.out.println(endDate);
		List<Price>p=v.findBycreatedAtBetween(startDate,endDate,id);
		List<salesDTO> k=new ArrayList<salesDTO>();
	    for(Price ue: p) {
			if(ue.getPerson().getU_id() ==id)
			{ 
				salesDTO v=new salesDTO(ue.getId(),ue.getPerson().getU_id(),ue.getCreatedAt(),ue.getPerson().getFirstName(),ue.getItem().getItem_Id(),ue.getItem().getItem_Name(),ue.getItem_Qty(),ue.getItem_Price());
				k.add(v);
			}
	  }
     return k;
		//	return new ResponseEntity<List<Price>>(v.findBycreatedAtBetween(date1,date2), HttpStatus.OK);
		
	}

    @PostMapping(value = "/postDetails")
	public String postdetails(@RequestBody PriceDTO p) {
		 Person d=null;
		 Item i=null;
         System.out.println(p.getPerson());
		 
         d = h.findById(p.getPerson());
         Price c  = new Price(); 
         i=g.findById(p.getItem());

        //System.out.println("hi");
        //System.out.println(i.getItem_Id());
		//System.out.println(d.getU_id());
         
         c.setPerson(d); 
         c.setItem(i);
         c.setItem_Price(p.getItem_Price());
         c.setItem_Qty(p.getItem_Qty());
         c.setCreatedAt(p.getCreatedAt()); 

        


   

        v.save(c);
		
		
		return "{\"response\":\"successfully added sale.\"}";
		
		
	}

	
	@PutMapping(value = "/putDetails/{id}")
	public String  putdetails(@RequestBody PriceDTO p, @PathVariable(value = "id") long id){
		 

		 Person d=null;
		 Item i=null;
         System.out.println(p.getPerson());
		 System.out.println(p.getCreatedAt());
		 
         d = h.findById(p.getPerson());
         Price c  = v.findById(id);
         i=g.findById(p.getItem());

        //System.out.println("hi");
        //System.out.println(i.getItem_Id());
		//System.out.println(d.getU_id());
         c.setId(id);
         c.setPerson(d); 
         c.setItem(i);
         c.setItem_Price(p.getItem_Price());
         c.setItem_Qty(p.getItem_Qty());
         c.setCreatedAt(p.getCreatedAt()); 

	    final Price updatedPerson = v.save(c);
	    return "{\"response\":\"successfully updated sale.\"}";
   }



	@DeleteMapping(value = "/deleteDetails/{ids}")
	public String deletedetails(@PathVariable(value = "ids") String a){

		for(String i:a.split(","))
		{
			v.delete(Long.parseLong(i));
		}

		return "{\"response\":\"successfully deleted sales.\"}";

	}
	
	
	

	@GetMapping(value="/getDetails/dates/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Date> getdatebyid(@PathVariable(value = "id") long id) 
		{
		   
		return v.finddates(id);
		
	  }
	
	@GetMapping(value="/getDetails/dates/{id}/{date}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Price> getdatabydate(@PathVariable(value = "id") long id,@PathVariable(value = "date") String date) throws ParseException 
		{
		Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date endDate=new Date(startDate.getTime()+(86399000));
        System.out.println(startDate);
        System.out.println(endDate);
		
		return v.findPrice(id,startDate,endDate);
		 }






}
