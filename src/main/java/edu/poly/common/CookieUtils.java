package edu.poly.common;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public static String get(String name, HttpServletRequest request) {  // get lay gtri cookie
		Cookie[] cookies = request.getCookies(); // ten truyen vao
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) { // so sanh ten cookie trung vs ten truyen vao
					return cookie.getValue(); // tra ve gtri cooki
				}
				
			}
		}
		return null;
	}
	
	public static Cookie add(String name, String value, int hours, HttpServletResponse response) {  // add luu cookie
		Cookie cookie = new Cookie(name, value); // tao doi tung cooki
		cookie.setMaxAge(60 * 60 * hours);  // thiet lap tg ton tai cho cooki
		cookie.setPath("/");     
		response.addCookie(cookie);
		
		return cookie;   // tra thong tin
	}
}
