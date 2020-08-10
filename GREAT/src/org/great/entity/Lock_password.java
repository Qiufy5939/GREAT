package org.great.entity;

public class Lock_password {
	
	
	public static String process(String password) {
		int length = password.length();
		
		return password.charAt(0)+"********"+password.charAt(length-1);
	}
}
