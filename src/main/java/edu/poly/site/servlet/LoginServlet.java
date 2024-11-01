package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import edu.poly.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = CookieUtils.get("username", request); 
	
		if (username == null) {  
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
		    return;
		}
		
		SessionUtils.add(request, "username", username); 
		request.getRequestDispatcher("/Homepage").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LoginForm form = new LoginForm();  
		
		try {
		
			BeanUtils.populate(form, request.getParameterMap()); 
			
			UserDao dao = new UserDao(); 
			User user = dao.findById(form.getUsername()); 
			
			if (user!= null && user.getPassword().equals(form.getPassword())) { 
				SessionUtils.add(request, "username", user.getUsername());   
				
				if (form.isRemember()) { 
					CookieUtils.add("username", form.getUsername(), 24, response);  
				}else {
					CookieUtils.add("username", form.getUsername(), 0, response);  
				}
				request.setAttribute("isLogin", true);
				request.setAttribute("name", user.getFullname());
				request.getRequestDispatcher("/Homepage").forward(request, response);
				return;
			}
			request.setAttribute("error", "invalid username or password");
			
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_LOGIN_PAGE); 
	}

}
