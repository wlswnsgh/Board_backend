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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Comment;
import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Repository.BulletinboardRepository;
import com.example.demo.Service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ServiceCommentController {
	
	@Autowired
	CommentService commentservice;
	
	@Autowired
	BulletinboardRepository bulletinboardrepository;
	
	@GetMapping("/board/{commentId}/comment")
	public ResponseEntity<List<Comment>> comments(@PathVariable("commentId") Long commentId) {
		List<Comment> dtos = commentservice.comments(commentId);
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
	@PostMapping("/board/comment/post/{commentpost}")
	public ResponseEntity<Comment> create(@PathVariable("commentpost") Long commentpost,
				                          @RequestBody Comment dto) {
		log.info("Received comment for post ID: {}", commentpost);
	    log.info("Comment data: {}", dto);
		Comment dtos = commentservice.create(commentpost, dto);
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
	@PatchMapping("/board/comment/patch/{id}")
	public ResponseEntity<Comment> update(@PathVariable("id") Long id,
										  @RequestBody Comment dto) {
		Comment updatedto = commentservice.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(updatedto);
	}
	
	@DeleteMapping("/board/comment/delet/{id}")
	public ResponseEntity<Comment> delete(@PathVariable("id") Long id) {
		Comment deletedto = commentservice.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(deletedto);
	}
	
}
