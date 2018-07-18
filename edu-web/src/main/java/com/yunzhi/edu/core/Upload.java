package com.yunzhi.edu.core;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class Upload {
	
	public static String uploadFile(String type,MultipartFile file) throws Exception{
		
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
	String basepath = "http://www.zerotop.top:8080/resource/img/";
		String url = basepath + System.currentTimeMillis()+"."+ext;	
		
		try {
			Client client = new Client();
			
			WebResource resource = client.resource(url);
			
			
			resource.put(String.class, file.getBytes());
			
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return url;
	}

	
}
