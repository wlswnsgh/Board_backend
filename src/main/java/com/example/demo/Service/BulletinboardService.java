package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.Bulletinboard;
import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Repository.BulletinboardRepository;

@Service
public class BulletinboardService {
	
	@Autowired
	private BulletinboardRepository bulletinboardrepository;
	
	public List<BulletinboardEntity> index() {
		return bulletinboardrepository.findAll();
	}
	
	public BulletinboardEntity Inshow(Long id){
		return bulletinboardrepository.findById(id).orElse(null);
	}
	
	public BulletinboardEntity SumitClick(Bulletinboard board) {
		BulletinboardEntity bulletinboardentity = board.toEntity();
		if(bulletinboardentity.getId() != null) {
			return null;
		}
		return bulletinboardrepository.save(bulletinboardentity);
	}
	
	public BulletinboardEntity Update(Long id,
									  Bulletinboard board) {
		BulletinboardEntity bulletinboardentity = board.toEntity();
		BulletinboardEntity target = bulletinboardrepository.findById(id).orElse(null);
		if(target == null || id != bulletinboardentity.getId()) {
			return null;
		}
		
		target.patch(bulletinboardentity);
		BulletinboardEntity updated = bulletinboardrepository.save(target);
		return updated;   
 	}
	
	public BulletinboardEntity delete(Long id) {
		BulletinboardEntity delete = bulletinboardrepository.findById(id).orElse(null);
		
		if(delete == null) {
			return null;
		} 
		
		bulletinboardrepository.delete(delete);
		return delete;
	}	
	
}
