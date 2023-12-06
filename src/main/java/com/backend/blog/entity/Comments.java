package com.backend.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comments {
	
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer cid;
	
 private String content;
 
 @JsonBackReference
 @ManyToOne
 private Post post;
 

	

}
