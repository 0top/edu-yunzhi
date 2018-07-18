package com.yunzhi.edu.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class Upload {
	
	public void upload(){
		String path = "D:\\me.jpg";
		
		String url = "http://www.zerotop.top:8080/file-upload/img/e.jpg";		


		Client client = new Client();
		
		WebResource resource = client.resource(url);
		
		try {
			byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(path));
			resource.put(readFileToByteArray);
			System.out.println("ok");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]){
		Upload up = new Upload();
		
		up.upload();
	}
}
