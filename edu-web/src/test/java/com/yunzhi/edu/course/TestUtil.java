package com.yunzhi.edu.course;

import com.yunzhi.edu.util.RandomId;

public class TestUtil {

	public TestUtil(){}
	
	public static void main(String args[]){
		
		for(int i=10000;i>0;i--){
			System.out.println(RandomId.createId());
		}
	}
	
}
