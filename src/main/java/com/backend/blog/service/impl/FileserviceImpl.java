package com.backend.blog.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import com.backend.blog.service.Fileservice;

public class FileserviceImpl implements Fileservice {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		     
		String name=file.getOriginalFilename();
		
		String filepath =path+File.separator+name;
		
		File f= new File(path);
		
		if(!f.exists())
		{
			f.mkdir();
		}
		
		Files.copy(file.getInputStream(), Paths.get(filepath));
		
		return name;
	}

}
