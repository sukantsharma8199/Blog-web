package com.backend.blog.payloads;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.backend.blog.entity.Category;
import com.backend.blog.entity.Comments;
import com.backend.blog.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Postdto {
	
    
	private Integer postid;
	
	private String title;
	
	private String contant;
	
	private String imagename;
	
	private Date  addeddate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private List<Comments> comments= new ArrayList<>();
	
	

}
