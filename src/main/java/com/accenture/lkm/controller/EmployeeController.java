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
import com.accenture.lkm.service.EmployeeService;



@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	
	@GetMapping(value="emp/controller/getDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Personbean>> getdetails() 
	{
		
	if((employeeService.getdetails()).isEmpty()) {
		System.out.println("no data found");
		return new ResponseEntity<List<Personbean>>(HttpStatus.NO_CONTENT);
		
	}else {
		return new ResponseEntity<List<Personbean>>(employeeService.getdetails(), HttpStatus.OK);
	}		
}
	
	@RequestMapping(value = "emp/controller/getDetails/{userid}", method = RequestMethod.GET)
	public ResponseEntity<Personbean> getUsersById(@PathVariable long userid){
		Personbean p  = employeeService.getUsersById(userid);
	
		if(p==null) {
			return new ResponseEntity<Personbean>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Personbean>(p, HttpStatus.OK);
		}		
	}
	
	
	
	
	
	@PostMapping(value = "emp/controller/postDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public String postdetails(@RequestBody Personbean p){
		
		employeeService.addPerson(p);
		return '{"output":"successfully added user."}';
		
		
	}
	
	
	
	
	
	
	
	@PutMapping(value = "emp/controller/putDetails/{id}")
	public ResponseEntity<Person>  putdetails(@RequestBody Person p, @PathVariable(value = "id") long id){
		 
	return employeeService.Update(p,id);
	

	
	}
	@DeleteMapping(value = "emp/controller/deleteDetails/{id}")
	public void deletedetails(@PathVariable(value = "id") long id){
		 
	employeeService.delete(id);
	
	}
	
}
