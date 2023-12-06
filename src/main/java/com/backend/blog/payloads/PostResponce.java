package com.backend.blog.payloads;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponce {
	
	private List<Postdto> contant;
	private int pagenumber;
	private int pagesize;
	private long totalelements;
	private int totalpages;
	private boolean lastpage;

}
