package com.accenture.lkm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.*;
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
import com.accenture.lkm.dao.Cust_PaymentDAO;

import com.accenture.lkm.entity.Cust_Payment;
import com.accenture.lkm.entity.Cust_PaymentDTO;
import com.accenture.lkm.entity.Item;
import com.accenture.lkm.entity.Person;
import com.accenture.lkm.entity.Price;
import com.accenture.lkm.entity.PriceDTO;
import com.accenture.lkm.entity.TransactionsDTO;


@CrossOrigin
@RestController
@RequestMapping("/customer")
public class Cust_PaymentController {
	@Autowired
	private Cust_PaymentDAO v;
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
	 
	 //TransactionDTO is Introduced
	 @GetMapping("/transactions/{userid}/{date}")
	 public List<TransactionsDTO> getTransactions(@PathVariable(value = "userid") long userid,@PathVariable(value = "date") String date) throws ParseException
	 {
		Date originalDate=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date transactionDate = new Date(originalDate.getTime()+(86399000));
		Date priceDate=new Date(originalDate.getTime()-(86400000)+(86399000));
		System.out.println(originalDate);
		System.out.println(priceDate);
		System.out.println(transactionDate);
		List<Object[]> results = v.getTransactions(userid,transactionDate,priceDate);
        List<TransactionsDTO> t=new ArrayList<>();
		 for (Object[] result : results) {
			 TransactionsDTO d=new TransactionsDTO();
		     d.setAmount(((BigDecimal)result[0]).longValue());
		     d.setPersonId(((BigInteger)result[3]).longValue());
		     d.setStatus((String)result[2]);
		     d.setTransaction_date((Date)result[1]);
		     t.add(d);
		    		 
		 } 
		return t;
		
		 
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
