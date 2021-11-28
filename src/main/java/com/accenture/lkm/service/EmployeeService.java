package com.accenture.lkm.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.accenture.lkm.entity.Person;



public interface EmployeeService {

	

	List<Person> getdetails();

	String postdetails(Person p);

	ResponseEntity<Person> Update(Person p,long id);

	void delete(Long id);
		

}