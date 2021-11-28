package com.accenture.lkm.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accenture.lkm.dao.EmployeeDAO;
import com.accenture.lkm.entity.Address;
import com.accenture.lkm.entity.Person;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDAO e;

	

	



	
	public List<Person> getdetails() {
		
		return e.findAll();
	}








	
	public String postdetails(Person p) {
		
		if(e.save(p) != null)
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}









	public ResponseEntity<Person>Update(Person v,long id) {
		
		Person p1 =(e.findById(id));
				
				
	    p1=new Person(id,v.getFirstName(),v.getLastName(), v.getPhone_no(), v.getAddress());
	    final Person updatedPerson = e.save(p1);
	    return ResponseEntity.ok(updatedPerson);
		
	    
	    
		
		
		
		
		
	}









	public void delete(Long id) {
		e.delete(id);
		
	}









	
	
}