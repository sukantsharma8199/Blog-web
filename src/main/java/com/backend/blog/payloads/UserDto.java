package com.backend.blog.payloads;



import java.util.ArrayList;
import java.util.List;

import com.backend.blog.entity.Comments;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class UserDto {
	
	
	private long Id;
	
	@NotEmpty
	@Size(min = 4, message = "user name must be min of 4 and not null")
	private String name;
	
	@Email(message = "email must be valid email")
	private  String email;
	
	@NotEmpty(message = "passward must be min 4 and max 10 ")
	@Size(min = 4,max = 10)
	private String password;
	@NotEmpty(message = "not null must be somthing")
	private String about;
	
	

}
