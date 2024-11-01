package edu.poly.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	
	//add luu thuoc tinh trong doi tuong session
	public static void add(HttpServletRequest request, String name, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}
	
	// lay gia tri truyen vao session
	public static Object get(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();

		return session.getAttribute(name);
	}
	
	// inv  huy bo session
	public static void invalidate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");  // huy bo
		session.invalidate();
	}
	
	// kiem tra nguoi dung dang nhap chua
	public static boolean isLogin(HttpServletRequest request) {
		return get(request, "username") != null; // username!= null thi dn
	}
	
	// tra ve gtri username da dang nhap vao 
	public static String getLoginedUsername(HttpServletRequest request) {
		Object username = get(request, "username");
		return username == null? null: username.toString();
	}
}
