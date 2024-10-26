package com.example.demo.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.BulletinboardEntity;

public interface BulletinboardRepository extends CrudRepository<BulletinboardEntity, Long>{
	
	@Override
	ArrayList<BulletinboardEntity> findAll();
	
}