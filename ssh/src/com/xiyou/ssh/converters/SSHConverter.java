package com.xiyou.ssh.converters;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class SSHConverter extends StrutsTypeConverter {

	private DateFormat dateFormat;
	
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("yyyy-MM-dd");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		//由于Class文件只有一份所以可以使用 ==
		System.out.println("converter...");
		if(arg2 == Date.class){
			System.out.println("converter...");
			try {
				return dateFormat.parse(arg1[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object arg1) {

		if(arg1 instanceof Date){
			return dateFormat.format((Date)arg1);
		}
		
		return null;
	}

}
