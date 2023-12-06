package com.backend.blog.service;

import java.util.List;

import com.backend.blog.payloads.UserDto;

public interface Userservice {
	
	public UserDto cresteuser(UserDto userDto);
	
	public UserDto updateuser(UserDto userDto, Integer userid);
	
	public UserDto getuserbyid(Integer userid);
	
	public List<UserDto> getallusers();
	
	public void deleteuser(Integer userid);

}
