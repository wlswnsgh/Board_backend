package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.Comment;
import com.example.demo.Entity.CommentEntity;
import com.example.demo.Repository.BulletinboardRepository;
import com.example.demo.Repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private BulletinboardRepository bulletinboardrepository;
	
	@Autowired
	private CommentRepository commentrepository;
	
	public List<Comment> comments(Long commentId) {
		List<CommentEntity> comments = commentrepository.findByComment(commentId);
		List<Comment> dtos = new ArrayList<Comment>();
		for(int i = 0; i < comments.size(); i++) {
			CommentEntity c =comments.get(i);
			Comment dto = Comment.creatCommentDto(c);
			dtos.add(dto);
		}
		return dtos;
	}
}
