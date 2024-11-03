package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dto.Comment;
import com.example.demo.Entity.BulletinboardEntity;
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
	
	@Transactional
	public Comment create(Long CommentId, Comment dto) {
		BulletinboardEntity board = bulletinboardrepository.findById(CommentId)
									.orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패!" +
										"대상 게시글이 없습니다."));
		CommentEntity comment = CommentEntity.createComment(dto, board);
		CommentEntity create = commentrepository.save(comment);
		return Comment.creatCommentDto(create);
	}
	
	@Transactional
	public Comment update(Long id, Comment cmt) {
		CommentEntity target = commentrepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패!" +
		              "대상 댓글이 없습니다."));
		target.patch(cmt);
		CommentEntity update = commentrepository.save(target);
		return Comment.creatCommentDto(update);
		
	}
	
	public Comment delete(Long id) {
		CommentEntity entity = commentrepository.findById(id)
							   .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 필요! " 
							   + "대상이 없습니다."));
		commentrepository.delete(entity);
		return Comment.creatCommentDto(entity);
	}
	
}
