package com.example.demo.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.BulletinboardEntity;

public interface BulletinboardRepository extends CrudRepository<BulletinboardEntity, Long>{
	
	@Override
	ArrayList<BulletinboardEntity> findAll();
	
	@Modifying
    @Transactional
    @Query(value = "UPDATE Board SET display_order = display_order - 1 WHERE display_order > :order", nativeQuery = true)
    void updateDisplayOrderAfterDelete(@Param("order") int order);
	
}