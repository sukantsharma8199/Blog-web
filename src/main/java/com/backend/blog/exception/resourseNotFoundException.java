package com.backend.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class resourseNotFoundException extends RuntimeException {
	
	String resousename;
	String fieldname;
	long fieldvalue;
	public resourseNotFoundException(String resousename, String fieldname, long userid) {
		super(String.format("%s not found with %s : %s", resousename,fieldname,userid));
		this.resousename = resousename;
		this.fieldname = fieldname;
		this.fieldvalue = userid;
	}
	
	

}
