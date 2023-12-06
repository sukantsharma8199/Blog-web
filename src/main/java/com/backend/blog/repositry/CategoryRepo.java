package com.backend.blog.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
