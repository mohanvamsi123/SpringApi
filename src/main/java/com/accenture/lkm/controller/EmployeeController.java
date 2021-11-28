package com.accenture.lkm.controller;

import java.util.Collection;
import java.util.List;

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

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.Person;
import com.accenture.lkm.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	
	@GetMapping(value="emp/controller/getDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getdetails()
	{
		if((employeeService.getdetails()).isEmpty())
		{
		return new ResponseEntity<>(
				null, HttpStatus.NOT_FOUND);
	}
		else
			{
			return new ResponseEntity<>(
					employeeService.getdetails(), HttpStatus.OK);
			}
		
	}
	
	
	
	
	
	@PostMapping(value = "emp/controller/postDetails")
	public String postdetails(@RequestBody Person p){
		System.out.println("Hello");
		System.out.println(p.getFirstName());
		return employeeService.postdetails(p);
		
		
	}
	
	@PutMapping(value = "emp/controller/putDetails/{id}")
	public ResponseEntity<Person>  putdetails(@RequestBody Person p, @PathVariable(value = "id") Long id){
		 
	return employeeService.Update(p,id);
	

	
	}
	@DeleteMapping(value = "emp/controller/deleteDetails/{id}")
	public void deletedetails(@PathVariable(value = "id") Long id){
		 
	employeeService.delete(id);
	
	}
	
}
