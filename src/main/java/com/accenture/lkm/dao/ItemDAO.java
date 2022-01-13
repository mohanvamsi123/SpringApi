package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.entity.Item;


public interface ItemDAO extends JpaRepository<Item, Long>{

	@Query("select i from Item i where i.Item_Status= ?1")
	List<Item> Find(boolean status); 

  @Query("select p from Item p  where p.Item_Id=:id")
   public Item findById(@Param("id") long id);

   /*@Modifying
   @Transactional
   @Query(
	   "UPDATE Item i 
        SET i.Item_Status = CASE  
		        WHEN ( i.Item_Status = true and i.Item_Id= ?1 ) THEN false
                WHEN ( i.Item_Status = false and i.Item_Id= ?1 ) THEN true
                ELSE  (i.Item_Status)
            END 
		WHERE   i.Item_Status IN (true,false)")
   void update(long id); */


    @Transactional
	@Modifying
	@Query("delete from Item p  where p.Item_Id=:id")
	void delete(@Param("id") long id);
	


	
	
	

}
