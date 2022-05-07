package com.accenture.lkm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.lkm.dao.PaymentDAO;
import com.accenture.lkm.entity.Cust_Payment;


@CrossOrigin
@RestController
@RequestMapping("/payment")
public class Cust_PaymentController {
	@Autowired
	private PaymentDAO v;
	
	@GetMapping("/payment/{id}/{date1}/{date2}")
	public List<Cust_Payment> getdetails(@PathVariable(value = "id") long id,@PathVariable(value = "date1") String date1,@PathVariable(value = "date2") String date2 ) throws Exception{
	Date datex1=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
	Date datex2=new SimpleDateFormat("yyyy-MM-dd").parse(date2);  
	return v.findBycreatedAtBetween(datex1,datex2,id);
	}
	
	@PostMapping("/payment")  
	private String insert(@RequestBody Cust_Payment c){  
	v.save(c);
	return "{\"response\":\"successfully inserted Payment.\"}";
	} 
	
	@PutMapping("/payment")  
	private String update(@RequestBody Cust_Payment c){  
	v.save(c);
	return "{\"response\":\"successfully updated Payment.\"}";
	} 
	
	
	@DeleteMapping(value = "/deleteDetails/{ids}")
	public String deletedetails(@PathVariable(value = "ids") long a){
	   v.delete(a);
	   return "{\"response\":\"successfully deleted Payment.\"}";
    }
}
