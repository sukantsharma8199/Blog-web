package com.backend.blog.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.blog.entity.User;
import com.backend.blog.exception.resourseNotFoundException;
import com.backend.blog.payloads.UserDto;
import com.backend.blog.repositry.UserRepo;
import com.backend.blog.service.Userservice;

@Service
public class Userserviceimpl implements Userservice {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto cresteuser(UserDto userDto) {
		User user = this.Dtotouser(userDto);
	 User savedUser =	this.userRepo.save(user);
		
		return this.usertoDto(savedUser);
	}

	@Override
	public UserDto updateuser(UserDto userDto,Integer userid) {
		User user=  this.userRepo.findById( userid).orElseThrow
		  (()->   new resourseNotFoundException("user","Id", userid) );
		  
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
	User saveUser=	this.userRepo.save(user);
	
  UserDto userDto2=	this.usertoDto(saveUser);
		  
		return userDto2;
	}

	@Override
	public UserDto getuserbyid( Integer userid) {
		User user= this.userRepo.findById( userid).orElseThrow
				(()-> new resourseNotFoundException("user","Id", userid));
		
	UserDto userDto=	 this.usertoDto(user);
		return userDto;
	}

	@Override
	public List<UserDto> getallusers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteuser(Integer userid) {
	 User user =	this.userRepo.findById(userid).orElseThrow
		(()-> new resourseNotFoundException("user","Id", userid));
	 
	         this.userRepo.delete(user);
		
		
		
	}
	
	private User Dtotouser(UserDto userDto) 
	{
		
		User user = this.modelMapper.map(userDto, User.class);
		
		
		return user;
		
	}
	
	private UserDto usertoDto(User user)
	{
	UserDto userDto = this.modelMapper.map(user, UserDto.class);
//	
//	userDto.setId(user.getId());
//	userDto.setName(user.getName());
//	userDto.setEmail(user.getEmail());
//	userDto.setPassword(user.getPassword());
//	userDto.setAbout(user.getAbout());
//	
	
	return userDto;
		
	}

}
