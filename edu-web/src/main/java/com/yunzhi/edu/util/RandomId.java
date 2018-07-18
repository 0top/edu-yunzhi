package com.yunzhi.edu.util;

import java.util.Random;

public class RandomId {
	
	static Random random = new Random(1000);
	
	public static String createId(){
		int k = 0;
		while(k < 100){
			k = random.nextInt(1000);
		}
		
		return System.currentTimeMillis()+""+k;
	}

}
