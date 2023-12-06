package com.backend.blog.service;


import java.util.List;

import com.backend.blog.payloads.PostResponce;
import com.backend.blog.payloads.Postdto;

public interface Postservice {
	
	public Postdto createpost(Postdto postdto, Integer userid, Integer categoryid);
	
	public Postdto updatepost(Postdto postdto, Integer postid);
	
	public void delletepost(Integer postid);
	
	public Postdto getpostbyId(Integer postid);
	
	public PostResponce getallpost(Integer pagenumber, Integer  pagesize, String sortby);
	
	public PostResponce getpostbyCategory( Integer categoryid, Integer pagenumber, Integer pagesize );
	
	public PostResponce getpostbyuser( Integer userid,Integer pagenumber, Integer pagesize );

}
