package com.example.demo.RepositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Service.BulletinboardService;

@SpringBootTest
public class BulletinboardRepositoryTest {
	
	@Autowired
	BulletinboardService bulletinboardservice;
	
	@Test
	void index() {
		BulletinboardEntity a = new BulletinboardEntity(1L,"aaa", "111");
		BulletinboardEntity b = new BulletinboardEntity(2L,"bbb", "222");
		BulletinboardEntity c = new BulletinboardEntity(3L,"ccc", "333");
		List<BulletinboardEntity> expects = new ArrayList<BulletinboardEntity>(Arrays.asList(a,b,c));
		List<BulletinboardEntity> entity = bulletinboardservice.index();
		assertEquals(expects.toString(), entity.toString());
	}
	  
}
