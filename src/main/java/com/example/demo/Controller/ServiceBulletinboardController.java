package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Bulletinboard;
import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Service.BulletinboardService;

@RestController
public class ServiceBulletinboardController {
	
	@Autowired
	private BulletinboardService bulletinboardService;
	
	@GetMapping("/forumsboard")
	public List<BulletinboardEntity> forumPage() {
	    return bulletinboardService.index();
	}
	
	@GetMapping("/submits/{id}")
	public BulletinboardEntity Inshows(@PathVariable("id") Long id){
		return bulletinboardService.Inshow(id);
	}
	
	@PostMapping("/submitboard")
	public ResponseEntity<BulletinboardEntity> SumitClicks(@RequestBody Bulletinboard bulletinboard) {
		BulletinboardEntity bulletinboardEntity = bulletinboardService.SumitClick(bulletinboard);
		return (bulletinboardEntity != null) ?
				ResponseEntity.status(HttpStatus.OK).body(bulletinboardEntity):
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PatchMapping("/submits/{id}/edits")
	public ResponseEntity<BulletinboardEntity> Updates(@PathVariable("id") Long id,
						 							  @RequestBody Bulletinboard board) {
		BulletinboardEntity updated = bulletinboardService.Update(id, board);
		return (updated != null) ?
				ResponseEntity.status(HttpStatus.OK).body(updated):
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  
 	}
	
	@DeleteMapping("/submits/{id}/deletes")
	public ResponseEntity<BulletinboardEntity> deletes(@PathVariable("id") Long id) {
		BulletinboardEntity target = bulletinboardService.delete(id);
		return (target != null) ?
			   ResponseEntity.status(HttpStatus.NO_CONTENT).build():
			   ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
