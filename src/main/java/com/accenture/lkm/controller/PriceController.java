package com.accenture.lkm.controller;


import java.util.Collection;
import java.util.List;
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
import com.accenture.lkm.business.bean.Personbean;
import com.accenture.lkm.entity.Person;

@CrossOrigin
@RestController
@RequestMapping("/price/controller")
public class PriceController
{


    @GetMapping(value="/getDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String,String>> getdetails(@RequestBody Price p) 
	{
	/*	if((itemService.getItems()).isEmpty()) {
			System.out.println("no data found");
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
			
		}else {

			return new ResponseEntity<List<Item>>(itemService.getItems(), HttpStatus.OK);
        } */
        String pname=p.getItem().getItem_Name();
        String iname=p.getPerson().getFirstName();
        //return List<pname,iname>;
        return new ResponseEntity<List<String,String>>(pname,iname, HttpStatus.OK);
     
	}	
}