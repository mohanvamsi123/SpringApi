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
        List<Price> PersonListEntity= v.findAll();
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
	public String  putdetails(@RequestBody Price p, @PathVariable(value = "id") long id){
        System.out.println(id);
		Price p1 =v.findById(id);
		System.out.println(p1);
		p1=new Price(id,p.getItem_Price() ,p.getItem_Qty(),p.getPerson(),p.getCreatedAt(),p.getItem());
	    final Price updatedPerson = v.save(p1);
	    return "{\"response\":\"successfully updated sale.\"}";
   }

    @DeleteMapping(value = "/deleteDetails/{id}")
	public void deletedetails(@PathVariable(value = "id") long id){

		v.delete(id);



}}
