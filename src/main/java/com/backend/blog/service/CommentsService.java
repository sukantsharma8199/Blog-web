package com.backend.blog.service;

import com.backend.blog.payloads.ComentsDto;

public interface CommentsService {
	
	public ComentsDto createcomment(ComentsDto comentsDto, Integer postid);
	
	public void deletecomment(Integer commentid);

}
