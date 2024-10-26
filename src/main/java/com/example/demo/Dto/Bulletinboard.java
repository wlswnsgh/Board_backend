package com.example.demo.Dto;

import com.example.demo.Entity.BulletinboardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor // 클래스의 모든 필드를 매개변수로 받는 생성자를 자동으로 생성
@ToString // 클래스의 필드 값을 포함한 문자열을 반환
@Builder
public class Bulletinboard {
	private Long id;
	private String title;
	private String content;
	
	// 에러: 생성자가 매개변수 목록이 같기 때문에 에러가 난다.
	// private String title;
	// private String content;
	
	// public Bulletinboard(String title, String content) {
	// this.title = title;
	// this.content = content;
	// }
	
	// Bulletinboard(String title, String content) 
	
	
	public BulletinboardEntity toEntity() {
		return new BulletinboardEntity(id, title, content);
	}
	
}
