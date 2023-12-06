package com.backend.blog.repositry;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.blog.entity.Category;
import com.backend.blog.entity.Post;
import com.backend.blog.entity.User;
import com.backend.blog.payloads.Postdto;

public interface Postrepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	Page<Post>  findByCategory(Category category, Pageable p);
	Page<Post> findByUser(User user, Pageable p);

}

