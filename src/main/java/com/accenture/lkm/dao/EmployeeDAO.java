package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.EmployeeEntity;
import com.accenture.lkm.entity.Person;

public interface EmployeeDAO  extends JpaRepository<Person, Integer>{
	
	@Transactional
	@Modifying
	@Query("delete from Person p  where p.U_id=:id")
	int delete(@Param("id") long id);
	
	@Query("select p from Person p  where p.U_id=:id")
	Person findById(@Param("id") long id);
	
	

}
