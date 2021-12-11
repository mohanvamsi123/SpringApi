package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.accenture.lkm.entity.Item;


public interface ItemDAO extends JpaRepository<Item, Long>{

	@Query("select i from Item i where i.Item_Status= ?1")
	List<Item> Find(boolean status); 
	
	
	

}
