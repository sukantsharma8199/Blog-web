package com.backend.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.blog.payloads.Apiresponce;

@RestControllerAdvice
public class GlobleExceptionHandller {
	
	
	@ExceptionHandler(resourseNotFoundException.class)
	public ResponseEntity<Apiresponce>  resoursenotfoundhandler( resourseNotFoundException ex)
	{
		String masagge =ex.getMessage();
		Apiresponce apiresponce=  new Apiresponce(masagge,false);
		
		return new ResponseEntity<Apiresponce>(apiresponce,HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handalmathodargnotvalid( MethodArgumentNotValidException ex)
	{
		Map<String, String> resp= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
		String message=	error.getDefaultMessage();
		String fieldname=((FieldError)error).getField();
		
		resp.put(fieldname, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
			
	}

}
