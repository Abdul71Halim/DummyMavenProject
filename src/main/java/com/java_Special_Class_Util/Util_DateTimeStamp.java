package com.java_Special_Class_Util;

import java.util.Date;

public class Util_DateTimeStamp {

	//public static void main(String[] args) {}*/
		
		public static String emailWith_DateTimeStamp() {
			
			Date date = new Date();
			System.out.println(date);
			String emailTimeStamp = date.toString().replace(" ", "-").replace(":", "-"); 
			System.out.println(emailTimeStamp);
			return "seleniumpanda"+ emailTimeStamp + "@gmail.com";
		
		

	}

}
