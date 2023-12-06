package com.backend.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.blog.payloads.Apiresponce;
import com.backend.blog.payloads.CategoryDto;
import com.backend.blog.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class Categorycontroller {
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/")
  public ResponseEntity<CategoryDto> createcategory(@Valid @RequestBody CategoryDto categoryDto)
  {
	CategoryDto cDto=  this.categoryService.createcat(categoryDto);
	return new ResponseEntity<CategoryDto>(cDto,HttpStatus.OK);
  }
	
	
	@PutMapping("/update/{catid}")
	public ResponseEntity<CategoryDto> updatecat(@RequestBody CategoryDto categoryDto, @PathVariable Integer catid)
	{
		
	  CategoryDto categoryDto2=	this.categoryService.udatecat(categoryDto, catid);
	  return new ResponseEntity<CategoryDto>(categoryDto2, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{catid}")
	public ResponseEntity<Apiresponce> deleteuser(@PathVariable Integer catid)
	{
		this.categoryService.deletecat(catid);
		return new ResponseEntity<Apiresponce>( new Apiresponce("delete", true), HttpStatus.OK);
	}
	
	@GetMapping("/get/{catid}")
	public ResponseEntity<CategoryDto> togetbyid(@PathVariable Integer catid)
	{
	  CategoryDto categoryDto=	this.categoryService.getcat(catid);
	  
	  return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<CategoryDto>>  getallcat()
	{
	  List<CategoryDto> categoryDto= 	this.categoryService.getallcat();
	  
	  return new ResponseEntity<List<CategoryDto>>(categoryDto,HttpStatus.OK);
	  
	  
	}
	
	
	
	

}
