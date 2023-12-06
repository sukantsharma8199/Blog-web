package com.backend.blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.modelmapper.internal.bytebuddy.description.type.TypeDefinition.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.blog.entity.Category;
import com.backend.blog.entity.Post;
import com.backend.blog.entity.User;
import com.backend.blog.exception.resourseNotFoundException;
import com.backend.blog.payloads.PostResponce;
import com.backend.blog.payloads.Postdto;
import com.backend.blog.repositry.CategoryRepo;
import com.backend.blog.repositry.Postrepo;
import com.backend.blog.repositry.UserRepo;
import com.backend.blog.service.Postservice;

@Service
public class PostserviceImpl implements Postservice {
	
	@Autowired
	private Postrepo postrepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private  ModelMapper modelMapper;
	

	@Override
	public Postdto createpost(Postdto postdto, Integer userid, Integer categoryid) {
	   
		User user=this.userRepo.findById(userid).orElseThrow(
				()-> new  resourseNotFoundException("user", "id" , userid));
		
		Category category = this.categoryRepo.findById(categoryid).orElseThrow(
				()-> new resourseNotFoundException("category", "id", categoryid)); 
		
		Post post = this.modelMapper.map(postdto, Post.class);
		
		post.setImagename("default.png");
		post.setAddeddate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
	Post savedpost=	this.postrepo.save(post);
		
		
		
		return this.modelMapper.map(savedpost, Postdto.class);
	}

	
	@Override
	public Postdto updatepost(Postdto postdto, Integer postid) {
		
	Post post=	this.postrepo.findById(postid).orElseThrow(
			()-> new resourseNotFoundException("user", "id", postid ));
	
	post.setTitle(postdto.getTitle());
	post.setContant(postdto.getContant());
	post.setImagename(postdto.getImagename());
	
 Post postupdated=this.postrepo.save(post);
		return this.modelMapper.map(postupdated, Postdto.class);
	}

	@Override
	public void delletepost(Integer postid) {
		
		
	Post post=	this.postrepo.findById(postid).orElseThrow(()-> new resourseNotFoundException("post", "id", postid));
		
	    this.postrepo.delete(post);       
	}

	@Override
	public Postdto getpostbyId(Integer postid) {
		
	Post post=	this.postrepo.findById(postid).orElseThrow(
			()-> new resourseNotFoundException("post", "id", postid));
		
		return this.modelMapper.map(post, Postdto.class);
	}

	@Override
	public PostResponce getallpost( Integer pagenumber, Integer  pagesize,String sortby) {
		
		
		Pageable p= PageRequest.of(pagenumber, pagesize, org.springframework.data.domain.Sort.by(sortby));
		
		
	      Page<Post> pagepost = this.postrepo.findAll(p);
	      
	      List<Post> allPosts= pagepost.getContent();
	      
	  
	  List<Postdto> postdtos =
			 allPosts.stream().map((post)-> this.modelMapper.map(post, Postdto.class)).collect(Collectors.toList());
		PostResponce postResponce= new PostResponce();

		
		postResponce.setContant(postdtos);
		postResponce.setPagenumber(pagepost.getNumber());
		postResponce.setPagesize(pagepost.getSize());
		postResponce.setTotalelements(pagepost.getTotalElements());
		postResponce.setTotalpages(pagepost.getTotalPages());
		postResponce.setLastpage(pagepost.isLast());
	  
	  
	  return postResponce;
	}

	@Override
	public PostResponce getpostbyCategory(Integer categoryid, Integer pagenumber, Integer pagesize) {
	 
		Category category=    this.categoryRepo.findById(categoryid).orElseThrow(
	    		()-> new resourseNotFoundException("category", "id", categoryid));
		Pageable p= PageRequest.of(pagenumber, pagesize);
	   Page<Post> pogepost = this.postrepo.findByCategory(category, p);
	   List<Post> allPosts=pogepost.getContent();
	
	List<Postdto> postdtos= 
			allPosts.stream().map((post)->  this.modelMapper.map(post, Postdto.class)).collect(Collectors.toList());
	 
	PostResponce postResponce = new PostResponce();
	
	postResponce.setContant(postdtos);
	postResponce.setPagenumber(pogepost.getNumber());
	postResponce.setPagesize(pogepost.getSize());
     postResponce.setTotalelements(pogepost.getTotalElements());
    postResponce.setTotalpages(pogepost.getTotalPages());
    postResponce.setLastpage(pogepost.isLast());
		return postResponce;
	}

	@Override
	public PostResponce getpostbyuser(Integer userid, Integer pagenumber, Integer pagesize) {
		User user	=  this.userRepo.findById(userid).orElseThrow
				(()-> new resourseNotFoundException("User", "id", userid));
		
		Pageable p= PageRequest.of(pagenumber, pagesize);
		
	  Page<Post> pagepost=   this.postrepo.findByUser(user,p);
	  
	  List<Post> allPosts = pagepost.getContent();
	  
	  List<Postdto> postdtos=  allPosts.stream().map((post)-> this.modelMapper.map(post, Postdto.class)).collect(Collectors.toList());
		
	  PostResponce postResponce= new PostResponce();
	  postResponce.setContant(postdtos);
	  postResponce.setPagenumber(pagepost.getNumber());
	  postResponce.setPagesize(pagepost.getSize());
	  postResponce.setTotalelements(pagepost.getTotalElements());
	  postResponce.setTotalpages(pagepost.getTotalPages());
	  postResponce.setLastpage(pagepost.isLast());
	  
	  return postResponce;
	}

}
