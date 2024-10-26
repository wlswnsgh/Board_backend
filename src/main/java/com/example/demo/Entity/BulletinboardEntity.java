package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Board")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BulletinboardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	public void patch(BulletinboardEntity Bbe) {
		if(Bbe.title != null) {
			this.title = Bbe.title;
		}
		if (Bbe.content != null) {
			this.content = Bbe.content;
		}
	}
	
}
