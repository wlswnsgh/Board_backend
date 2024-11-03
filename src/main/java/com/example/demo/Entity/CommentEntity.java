package com.example.demo.Entity;

import com.example.demo.Dto.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Comment")

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="bulletinboardentity_id") 
	private BulletinboardEntity bulletinboardentityId;
	
	@Column
	private String nickname;
	
	@Column
	private String body;
    
    public static CommentEntity createComment(Comment dto, BulletinboardEntity board) {
   	 if(dto.getId() != null) {
   		 throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 함니다.");
   	 } if(dto.getCommentId() != board.getId()) {
   		 throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 함니다.");
   	 }
   	 
   	 return new CommentEntity(
   			 dto.getId(),
   			 board,
   			 dto.getNickname(),
   			 dto.getBody()
   	 );
   	 
    }
    
    public void patch(Comment cmt) {
    	if(this.id != cmt.getId()) {
    		throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력됐습니다.");
    	} 
    	
    	if(cmt.getNickname() != null) {
    		this.nickname = cmt.getNickname();
    	}
    	
    	if(cmt.getBody() != null) {
    		this.body = cmt.getBody();
    	}
    }
	
}
