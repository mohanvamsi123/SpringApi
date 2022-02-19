package com.accenture.lkm.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.accenture.lkm.entity.Price;
public interface PriceDAO extends JpaRepository<Price, Long>{

    @Query("select p from Price p  where p.id=:id")
	Price findById(@Param("id") long id);
}