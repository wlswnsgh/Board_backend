package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Dto.Bulletinboard;
import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Repository.BulletinboardRepository;

@RestController
public class CommentController {

	@Autowired
	private BulletinboardRepository bulletinboardrepository;
	
	@GetMapping("/forumsboard")
	public List<BulletinboardEntity> forumPage() {
	    return bulletinboardrepository.findAll();
	}
	
	@GetMapping("/submits/{id}")
	public BulletinboardEntity Inshow(@PathVariable("id") Long id){
		return bulletinboardrepository.findById(id).orElse(null);
	}
	
	@PostMapping("/submitboard")
	public BulletinboardEntity SumitClick(@RequestBody Bulletinboard board) {
		BulletinboardEntity bulletinboardentity = board.toEntity();
		return bulletinboardrepository.save(bulletinboardentity);
	}
	
	@PatchMapping("/submits/{id}/edits")
	public ResponseEntity<BulletinboardEntity> Update(@PathVariable("id") Long id,
						 							  @RequestBody Bulletinboard board) {
		BulletinboardEntity bulletinboardentity = board.toEntity();
		BulletinboardEntity target = bulletinboardrepository.findById(id).orElse(null);
		
		if(target == null || id != bulletinboardentity.getId()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		target.patch(bulletinboardentity);
		BulletinboardEntity updated = bulletinboardrepository.save(target);
		return ResponseEntity.status(HttpStatus.OK).body(updated);           
 	}
	
	@DeleteMapping("/submits/{id}/deletes")
	public ResponseEntity<BulletinboardEntity> delete(@PathVariable("id") Long id) {
		BulletinboardEntity delete = bulletinboardrepository.findById(id).orElse(null);
		
		if(delete == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} 
		
		bulletinboardrepository.delete(delete);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
