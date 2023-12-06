package com.backend.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.blog.payloads.Apiresponce;
import com.backend.blog.payloads.PostResponce;
import com.backend.blog.payloads.Postdto;
import com.backend.blog.payloads.UserDto;
import com.backend.blog.service.Postservice;

@RestController
@RequestMapping("/Api")
public class Postcontroller {
	
	@Autowired
	private Postservice postservice;
	
	@PostMapping("/user/{userid}/category/{categoryid}")
    public ResponseEntity<Postdto>  createpost(@RequestBody Postdto postdto,
    		@PathVariable  Integer userid, 
    		@PathVariable Integer categoryid)
    {
	Postdto postcreatedPost=this.postservice.createpost(postdto, userid, categoryid);
		return new ResponseEntity<Postdto>(postcreatedPost,HttpStatus.OK);
    }
	
	@GetMapping("/post/{postid}")
	public ResponseEntity<Postdto> findpostbyid(@PathVariable Integer postid)
	{
	 Postdto postdto=	this.postservice.getpostbyId(postid);
		
		return  new ResponseEntity<Postdto>(postdto, HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponce> togetallpost(
			@RequestParam(value = "pagenumber", defaultValue = "0", required = false)  Integer pagenumber ,
			@RequestParam(value = "pagesize", defaultValue = "5", required = false) Integer pagesize,
			@RequestParam (value = "sortby", defaultValue = "postid",required = false) String sortby
			
			)
	{
	 PostResponce postdtos = this.postservice.getallpost( pagenumber ,pagesize,sortby);
		return new ResponseEntity<PostResponce>( postdtos, HttpStatus.OK);
	}
	
	@GetMapping("/categpory/{categoryid}/post")
	public ResponseEntity<PostResponce> getbycategory(@PathVariable Integer categoryid,
			@RequestParam (value = "pagenumber", defaultValue = "0", required = false) Integer pagenumber,
			@RequestParam(value =  "pagesize", defaultValue = "2", required = false) Integer pagesize
			)
	{
	PostResponce postdtos=	this.postservice.getpostbyCategory(categoryid,pagenumber,pagesize);
		
		return new ResponseEntity<PostResponce>(postdtos,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userid}/post")
	public ResponseEntity<PostResponce> getbyuser(@PathVariable Integer userid,
			@RequestParam (value = "pagenumber", defaultValue = "0", required = false) Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = "5", required = false) Integer pagesize
			)
	{
	PostResponce postdtos=	this.postservice.getpostbyuser(userid, pagenumber,pagesize);
		return new ResponseEntity<PostResponce>(postdtos,HttpStatus.OK);
	}
	
	@PutMapping("/delete/{postid}/post")
	public ResponseEntity<Apiresponce> deletepostbyid(@PathVariable Integer postid)
	{
		this.postservice.delletepost(postid);
		return new ResponseEntity<Apiresponce>( new Apiresponce("deleted sussfuly", true), HttpStatus.OK); 
	}
	
	@PutMapping("/update/{postid}")
	public ResponseEntity<Postdto> postupdated(@RequestBody Postdto postdto, @PathVariable Integer postid )
	
	{
	  Postdto postdto2=	this.postservice.updatepost(postdto, postid);
	  
	  return new ResponseEntity<Postdto>(postdto2,HttpStatus.OK);
	}

	

}
