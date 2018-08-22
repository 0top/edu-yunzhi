package com.yunzhi.edu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateForm {
	
	public static String formater(){
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("EEEE-MMMM-dd-yyyy"); 
		Date date = new Date(); 
		return bartDateFormat.format(date); 
	}

}
