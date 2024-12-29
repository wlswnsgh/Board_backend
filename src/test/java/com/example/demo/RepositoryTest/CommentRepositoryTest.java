package com.example.demo.RepositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Entity.CommentEntity;
import com.example.demo.Repository.CommentRepository;

@DataJpaTest
@Transactional
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository commentrepository;
	
//	@Test
//	void findByComment() {
//		{
//			Long CommentId = 4L;
//			List<CommentEntity> comment = commentrepository.findByComment(CommentId);
//			BulletinboardEntity board = new BulletinboardEntity(4L, "당신의 취미는?", "댓글 고고고");
//			CommentEntity a = new CommentEntity(1L, board, "JIN", "안녕");
//			CommentEntity b = new CommentEntity(2L, board, "JUN", "반가워");
//			CommentEntity c = new CommentEntity(3L, board, "HO", "고마워");
//			List<CommentEntity> expects = Arrays.asList(a, b, c);
//			assertEquals(expects.toString(), comment.toString(), "4번 댓글 출력");		
//		}
//	}

}
