package com.accenture.lkm.controller;



import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin
@RestController
@RequestMapping("/price/controller")
public class PriceController
{
  
     
	@Autowired
	private PriceDAO v;
    private ItemDAO g;
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
	public List<String> getdetails(@PathVariable(value = "id") long id) 
	{
        List<String>d=new ArrayList<String>();


	/*	if((itemService.getItems()).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
			
		}else {

			return new ResponseEntity<List<Item>>(itemService.getItems(), HttpStatus.OK);
        } */
        List<Price> PersonListEntity= v.findAll();
        Price k=new Price();
	    for(Price ue: PersonListEntity) {
			if(ue.getId()==id)
			{ 
				 k=ue;
				break;
			}
	  }


        String pname=k.getItem().getItem_Name();
        String iname=k.getPerson().getFirstName();
        d.add(pname);
        d.add(iname);
        return d;
       // return new ResponseEntity<List<String,String>>(pname,iname, HttpStatus.OK);
     
	}	

    @PostMapping(value = "/postDetails")
	public String postdetails(@RequestBody PriceDTO p) {
         Person d = h.findById(p.getPerson());
         Price c  = new Price(); //Create a new Many object
         Item i=g.findById(p.getItem());

        System.out.println("hi");
        System.out.println(i.getItem_Id());
		System.out.println(d.getU_id());
         
         c.setPerson(d); 
         c.setItem(i);
         c.setItem_Price(p.getItem_Price());
         c.setItem_Qty(p.getItem_Qty());
         c.setCreatedAt(p.getCreatedAt()); 

        


   

        v.save(c);
		
		
		return "success";
		
		
	}
	

    

}