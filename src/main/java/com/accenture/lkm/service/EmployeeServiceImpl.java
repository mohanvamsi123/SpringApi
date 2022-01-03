package com.accenture.lkm.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.accenture.lkm.business.bean.Personbean;
import com.accenture.lkm.dao.EmployeeDAO;
import com.accenture.lkm.entity.Address;
import com.accenture.lkm.entity.Person;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDAO e;

	

	



	
	public List<Personbean> getdetails() {
		
		List<Person> PersonListEntity= e.findAll();
		List<Personbean>PersonListModel=new ArrayList<Personbean>();
		
		for(Person ue: PersonListEntity) {
			Personbean b=new Personbean();
			BeanUtils.copyProperties(ue, b);
			PersonListModel.add(b);
	

	}
	return PersonListModel;
	}





	









	public ResponseEntity<Person>Update(Person v,long id) {
		
		Person p1 =(e.findById(id));
				
				
	    p1=new Person(id,v.getFirstName(), v.getPhone_no(),  /*v.getCreatedDate(),*/ v.getAddress());
	    final Person updatedPerson = e.save(p1);
	    return ResponseEntity.ok(updatedPerson);
		
	    
	    
		
		
		
		
		
	}

	public Personbean getUsersById(long id) {
		Person ue = e.findById(id);
		Personbean um = new Personbean();
		BeanUtils.copyProperties(ue, um);
		return um;
	}







	public void delete(long id) {
		e.delete(id);
		
	}







	@Override
	public void addPerson(Person p) {
		
		// Person ue = new Person();
		// BeanUtils.copyProperties(p, ue);
		e.save(p);

		
	}















































	










































	
















	















	
	

























	
	
}