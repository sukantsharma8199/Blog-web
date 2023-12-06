package com.backend.blog.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.blog.entity.Comments;
import com.backend.blog.payloads.ComentsDto;

public interface Comentsrepo extends JpaRepository<Comments, Integer > {
	
	

}
