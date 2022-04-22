package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lkm.entity.Cust_Payment;
import com.accenture.lkm.entity.Person;

public interface PaymentDAO extends JpaRepository<Cust_Payment, Long>{
	

}
