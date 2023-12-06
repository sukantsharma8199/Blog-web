package com.backend.blog.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.blog.payloads.Apiresponce;
import com.backend.blog.payloads.UserDto;
import com.backend.blog.service.Userservice;

import jakarta.validation.Valid;

@RestController
public class Usercontroller {     
	
	@Autowired
	private Userservice userservice;
	
	
	@PostMapping("/api/created")
	public ResponseEntity<UserDto> adduser(@Valid @RequestBody UserDto userDto)
	{
	UserDto uDto =   this.userservice.cresteuser(userDto);
	   
	   return  new ResponseEntity<>(uDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/api/update/{userid}")
	public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userDto, @PathVariable Integer userid)
	{ 
	UserDto userDto2=	this.userservice.updateuser(userDto, userid);
	
	return   new  ResponseEntity<>(userDto2,HttpStatus.OK);
		
		
	}
	
	 @DeleteMapping("/api/delete/{userid}")
	public ResponseEntity<Apiresponce> deleteuser(  @PathVariable Integer userid)
	{
		this.userservice.deleteuser(userid);
		
		return new ResponseEntity <Apiresponce>(new Apiresponce("delete succes" , true), HttpStatus.OK );
		
		
	}
	 
	 @GetMapping( "/api/getit/{userid}")
	 public ResponseEntity<UserDto> getoneuser( @PathVariable Integer userid)
	 {
	 UserDto userDto=	this.userservice.getuserbyid(userid);
	 
	 return new ResponseEntity<>(userDto,HttpStatus.OK);
		
		 
	 }
	 
	 
	 

}
