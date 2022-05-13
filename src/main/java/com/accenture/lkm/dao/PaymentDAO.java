package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.accenture.lkm.entity.Cust_Payment;


public interface PaymentDAO extends JpaRepository<Cust_Payment, Long>{
	
	 @Transactional
	 @Modifying
	 @Query("delete from Cust_Payment p where p.Id=:id")
	 void delete(@Param("id") long id);
	 
	//@Query("select p from Cust_Payment p where p.createdAt>=?1 and p.createdAt<=?2 and p.person.U_id=?3")
	 @Query("select p from Cust_Payment p where date(convert_tz(p.transaction_date,'+00:00','+05:30'))>=?1 and date(convert_tz(p.transaction_date,'+00:00','+05:30'))<=?2 and p.person.U_id=?3")
     List<Cust_Payment>findBycreatedAtBetween(Date date1,Date date2,long id);
     
     
    @Query("select p from Cust_Payment p  where p.id=:id")
 	Cust_Payment findById(@Param("id") long id);
}
