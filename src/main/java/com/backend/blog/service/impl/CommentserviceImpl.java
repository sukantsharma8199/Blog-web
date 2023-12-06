package com.backend.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.blog.entity.Comments;
import com.backend.blog.entity.Post;
import com.backend.blog.entity.User;
import com.backend.blog.exception.resourseNotFoundException;
import com.backend.blog.payloads.ComentsDto;
import com.backend.blog.repositry.Postrepo;
import com.backend.blog.repositry.UserRepo;
import com.backend.blog.repositry.Comentsrepo;
import com.backend.blog.service.CommentsService;

@Service
public class CommentserviceImpl implements CommentsService {
	
	@Autowired
	private Comentsrepo comentsrepo;
	
	@Autowired
	private Postrepo postrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	

	@Override
	public ComentsDto createcomment(ComentsDto comentsDto, Integer postid) {
		
	Post post=	this.postrepo.findById(postid).orElseThrow(()-> new resourseNotFoundException("post", "id", postid));
	
	
	 Comments comments=  this.modelMapper.map(comentsDto, Comments.class);
	 
	 comments.setPost(post);
	 
	   Comments comments2= this.comentsrepo.save(comments);
	
		return this.modelMapper.map(comments2, ComentsDto.class);
	}

	@Override
	public void deletecomment(Integer commentid) {
		   
		Comments comments= this.comentsrepo.findById(commentid).orElseThrow(()-> new resourseNotFoundException("Comment ", "id", commentid));
		
	  this.comentsrepo.delete(comments);
	}

}
