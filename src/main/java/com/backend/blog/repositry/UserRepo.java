package com.backend.blog.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.blog.entity.User;



public interface UserRepo extends JpaRepository<User, Integer> {

}
