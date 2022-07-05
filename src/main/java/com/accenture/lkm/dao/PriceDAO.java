package com.accenture.lkm.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import com.accenture.lkm.entity.Price;

import java.time.LocalDate;
import java.util.*;
public interface PriceDAO extends JpaRepository<Price, Long>{

    @Transactional
	@Modifying
	@Query("delete from Price p  where p.Id=:id")
	void delete(@Param("id") int id);

    @Query("select p from Price p where p.createdAt>=convert_tz(?1,'+00:00','-05:30') and p.createdAt<=convert_tz(?2,'+00:00','-05:30') and p.person.U_id=?3")
    //@Query("select p from Price p where date(convert_tz(p.createdAt,'+00:00','+05:30'))>=?1 and date(convert_tz(p.createdAt,'+00:00','+05:30'))<=?2 and p.person.U_id=?3")
    List<Price>findBycreatedAtBetween(Date date1,Date date2,long id);
   
    

    @Query("select p from Price p  where p.id=:id")
	Price findById(@Param("id") long id);

  
    //@Query("select Distinct p.createdAt from Price p  where p.person.U_id=?1")
    @Query("select Distinct date(convert_tz(p.createdAt,'+00:00','+05:30')) from Price p where p.person.U_id=:p_id order by p.createdAt ASC")
	List<Date> finddates(@Param("p_id") long id);
    
    @Query("select p from Price p  where p.person.U_id=?1 and p.createdAt>=convert_tz(?2,'+00:00','-05:30') and p.createdAt<convert_tz(?3,'+00:00','-05:30')")
   	List<Price> findPrice(long id,Date startdate,Date enddate);
    
}
	
