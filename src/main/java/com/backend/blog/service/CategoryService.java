package com.backend.blog.service;

import java.util.List;

import com.backend.blog.payloads.CategoryDto;

public interface CategoryService {
	
	public CategoryDto createcat(CategoryDto categoryDto);
	public CategoryDto udatecat(CategoryDto categoryDto, Integer catid);
	public void deletecat(Integer catid);
	public CategoryDto getcat(Integer catid);
	public List<CategoryDto> getallcat();
	
	

}
