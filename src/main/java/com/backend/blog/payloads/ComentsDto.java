package com.backend.blog.payloads;

import com.backend.blog.entity.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ComentsDto {
	
	 private Integer cid;
		
	 private String content;

}
