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
   	 
   	 return new CommentEntity(
   			 dto.getId(),
   			 board,
   			 dto.getNickname(),
   			 dto.getBody()
   	 );
   	 
    }
	
}
