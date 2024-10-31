package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

	@Query(value =
			"SELECT * " +
			"FROM comment " +
			"WHERE bulletinboardentity_id = :bulletinboardentity_id",
			nativeQuery = true)
	List<CommentEntity> findByComment(@Param("bulletinboardentity_id") Long bulletinboardentity_id);

	List<CommentEntity> findByNickname(String nickname);
}
