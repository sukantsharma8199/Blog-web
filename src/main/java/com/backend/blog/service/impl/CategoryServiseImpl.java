package com.backend.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.blog.entity.Category;
import com.backend.blog.exception.resourseNotFoundException;
import com.backend.blog.payloads.CategoryDto;
import com.backend.blog.repositry.CategoryRepo;
import com.backend.blog.service.CategoryService;

@Service
public class CategoryServiseImpl implements CategoryService {
	
	

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createcat(CategoryDto categoryDto) {
		    Category category = this.modelMapper.map(categoryDto, Category.class);
		  Category savedCategory=  this.categoryRepo.save(category);
		  
		return this.modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto udatecat(CategoryDto categoryDto, Integer catid) {
		
		
	   Category category = this.categoryRepo.findById(catid).orElseThrow(
			   ()-> new resourseNotFoundException("categry", "id", catid));
	   
	   category.setCategoryTital(categoryDto.getCategoryTital());
	   category.setCategorydescription(categoryDto.getCategorydescription());
	   
	   this.categoryRepo.save(category);
	  
	  
		return this.modelMapper.map(category, CategoryDto.class) ;
	}

	@Override
	public void deletecat(Integer catid) {
		
		Category category=  this.categoryRepo.findById(catid).orElseThrow(
				   ()-> new resourseNotFoundException("category", "id", catid));
		
		
	              this.categoryRepo.delete(category);
		
		
	}

	@Override
	public CategoryDto getcat(Integer catid) {
	  Category category=this.categoryRepo.findById(catid).orElseThrow(
			  ()-> new resourseNotFoundException("categary", "Id", catid));
	  
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getallcat() {
		 List<Category> categories= this.categoryRepo.findAll();
		 
	List<CategoryDto> categoryDtos=	 categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
	}

	

	
	
	
}


