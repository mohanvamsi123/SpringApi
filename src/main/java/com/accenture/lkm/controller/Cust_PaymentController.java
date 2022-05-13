package com.accenture.lkm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.dao.EmployeeDAO;
import com.accenture.lkm.dao.PaymentDAO;
import com.accenture.lkm.entity.Cust_Payment;
import com.accenture.lkm.entity.Cust_PaymentDTO;
import com.accenture.lkm.entity.Item;
import com.accenture.lkm.entity.Person;
import com.accenture.lkm.entity.Price;
import com.accenture.lkm.entity.PriceDTO;


@CrossOrigin
@RestController
@RequestMapping("/customer")
public class Cust_PaymentController {
	@Autowired
	private PaymentDAO v;
	@Autowired
	private EmployeeDAO h;
	
	@GetMapping("/payment/{id}/{date1}/{date2}")
	public List<Cust_Payment> getdetails(@PathVariable(value = "id") long id,@PathVariable(value = "date1") String date1,@PathVariable(value = "date2") String date2 ) throws Exception{
	Date datex1=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
	Date datex2=new SimpleDateFormat("yyyy-MM-dd").parse(date2);  
	return v.findBycreatedAtBetween(datex1,datex2,id);
	}
	
	 @GetMapping(value="/getPayments",produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Cust_Payment>> getdetails() 
		{
		
         return new ResponseEntity<List<Cust_Payment>>(v.findAll(), HttpStatus.OK);
			
		}	
	
	@PostMapping("/payment")  
	private String insert(@RequestBody Cust_PaymentDTO c){  
		
		  Person d=null;
	      d = h.findById(c.getPerson());
	      Cust_Payment p=new Cust_Payment();
	     
	      p.setAmount(c.getAmount());
	      p.setTransaction_date(c.getTransaction_date());
	      p.setPerson(d);
	      v.save(p);
	     
	 return "{\"response\":\"successfully inserted Payment.\"}";
	} 
	
	@PutMapping("/payment/{id}")  
	private String update(@RequestBody Cust_PaymentDTO c,@PathVariable(value = "id") long id){  
		 Person d=null;
	      d = h.findById(c.getPerson());
	      Cust_Payment p=v.findById(id);
	      p.setId(id);
	     
	      p.setAmount(c.getAmount());
	      p.setTransaction_date(c.getTransaction_date());
	      p.setPerson(d);
	      v.save(p);
	return "{\"response\":\"successfully updated Payment.\"}";
	} 
	
	
	@DeleteMapping(value = "/deleteDetails/{ids}")
	public String deletedetails(@PathVariable(value = "ids") long a){
	   v.delete(a);
	   return "{\"response\":\"successfully deleted Payment.\"}";
    }
	
	
	
	
	
}
