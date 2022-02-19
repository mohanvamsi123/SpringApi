package com.accenture.lkm.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.accenture.lkm.entity.Price;
public interface PriceDAO extends JpaRepository<Price, Long>{

    @Transactional
	@Modifying
	@Query("delete from Price p  where p.Id=:id")
	void delete(@Param("id") int id);
}