package com.accenture.lkm.service;


import java.util.List;


import org.springframework.http.ResponseEntity;

import com.accenture.lkm.business.bean.Personbean;
import com.accenture.lkm.entity.Person;



public interface EmployeeService {

	

	List<Personbean> getdetails();

	
	void addPerson(Personbean p);

	ResponseEntity<Person> Update(Person p,long id);

	void delete(long id);
	
	Personbean getUsersById(long id);
		

}