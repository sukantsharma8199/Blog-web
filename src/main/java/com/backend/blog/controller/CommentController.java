package com.backend.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.blog.payloads.ComentsDto;
import com.backend.blog.service.CommentsService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentsService commentsService;
	
	@PostMapping("/Api/{postid}")
	public ResponseEntity<ComentsDto> createcomment(@RequestBody ComentsDto comentsDto, 
			@PathVariable Integer postid
			)
	   {
		
	ComentsDto comentsDto2=	this.commentsService.createcomment(comentsDto, postid);
		
	
	     return new ResponseEntity<ComentsDto>(comentsDto2, HttpStatus.OK);
	}
	
	@DeleteMapping("/Api/{commentid}")
	public void deletecomment(@PathVariable Integer commentid)
	{
	    this.commentsService.deletecomment(commentid);	
	}
	
	

}
