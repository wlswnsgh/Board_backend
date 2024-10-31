package com.example.demo.Dto;

import com.example.demo.Entity.CommentEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
     private Long id;
     private Long commentId;
     private String nickname;
     private String body;
     
     public static Comment creatCommentDto(CommentEntity comment) {
    	 return new Comment(
    			 comment.getId(),
    			 comment.getBulletinboardentityId().getId(),
    			 comment.getNickname(),
    			 comment.getBody()
    	);
     }
}
