package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.accenture.lkm.entity.Cust_Payment;




public interface Cust_PaymentDAO extends JpaRepository<Cust_Payment, Long>{
	
	 @Transactional
	 @Modifying
	 @Query("delete from Cust_Payment p where p.Id=:id")
	 void delete(@Param("id") long id);
	 
	//@Query("select p from Cust_Payment p where p.createdAt>=?1 and p.createdAt<=?2 and p.person.U_id=?3")
	 @Query("select p from Cust_Payment p where date(convert_tz(p.transaction_date,'+00:00','+05:30'))>=?1 and date(convert_tz(p.transaction_date,'+00:00','+05:30'))<=?2 and p.person.U_id=?3")
     List<Cust_Payment>findBycreatedAtBetween(Date date1,Date date2,long id);
     
     
    @Query("select p from Cust_Payment p  where p.id=:id")
 	Cust_Payment findById(@Param("id") long id);
    
    @Query(value = "select sum(total_price) as dayTotal,date(convert_tz(created_at,'+00:00','+05:30')) as transaction_date,\"Debited\" as Status,person_id from price where person_id=?1 and created_at<convert_tz(?3,'+00:00','-05:30') group by date(convert_tz(created_at,'+00:00','+05:30')) union all\r\n"
    		+"select sum(amount) as dayTotal,date(convert_tz(created_at,'+00:00','+05:30')) as transaction_date,\"Credited\" as Status,person_id from cust_payment where person_id=?1 and created_at<convert_tz(?2,'+00:00','-05:30')  group by date(convert_tz(created_at,'+00:00','+05:30')) order by transaction_date ASC;" , nativeQuery = true)
    List<Object []> getTransactions(long userid,Date date,Date priceDate);

}
