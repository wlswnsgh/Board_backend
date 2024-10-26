package com.example.demo.CommentRepositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Entity.CommentEntity;
import com.example.demo.Repository.BulletinboardRepository;
import com.example.demo.Repository.CommentRepository;

@DataJpaTest
public class Comment_Repository_Test {
	
	@Autowired
	CommentRepository commentrepository;
	
	@Autowired
    BulletinboardRepository bulletinboardRepository;
	
	private BulletinboardEntity bulletinboardentity;
	
    @BeforeEach
    void setUp() {
        // BulletinboardEntity 데이터 생성 및 저장
        bulletinboardentity = new BulletinboardEntity(1L, "a", "a");
        bulletinboardRepository.save(bulletinboardentity);

        // CommentEntity 데이터 생성 및 저장
        CommentEntity a = new CommentEntity(1L, bulletinboardentity, "jin", "베태랑");
        CommentEntity b = new CommentEntity(2L, bulletinboardentity, "jun", "곤지암");
        CommentEntity c = new CommentEntity(3L, bulletinboardentity, "ho", "최애의 아이");
        commentrepository.saveAll(Arrays.asList(a, b, c));
        
        System.out.println("Saved BulletinboardEntity: " + bulletinboardentity);
        System.out.println("Saved CommentEntities: " + Arrays.asList(a, b, c));
    }

    @Test
    void findByCommentId() {
        Long commentid = 1L;
        List<CommentEntity> comments = commentrepository.findByComment(commentid);
        System.out.println("Retrieved comments: " + comments);
        List<CommentEntity> expected = Arrays.asList(
            new CommentEntity(1L, bulletinboardentity, "jin", "베태랑"),
            new CommentEntity(2L, bulletinboardentity, "jun", "곤지암"),
            new CommentEntity(3L, bulletinboardentity, "ho", "최애의 아이")
        );
        assertEquals(expected.toString(), comments.toString(), "4번글 출력");
    }
	
}
