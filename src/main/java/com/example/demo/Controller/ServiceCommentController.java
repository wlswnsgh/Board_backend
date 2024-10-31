package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Comment;
import com.example.demo.Service.CommentService;

@RestController
public class ServiceCommentController {
	
	@Autowired
	CommentService commentservice;
	
	@GetMapping("/board/{commentId}/comment")
	public ResponseEntity<List<Comment>> comments(@PathVariable("commentId") Long commentId) {
		List<Comment> dtos = commentservice.comments(commentId);
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
}
