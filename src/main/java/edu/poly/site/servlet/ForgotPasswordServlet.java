package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");  // lay email va username tu form
			String username = request.getParameter("username");
			
			UserDao dao = new UserDao();  //tao
			User user = dao.findByUsernameAndEmail(username, emailAddress); // tim t.tin tu email
			
			if (user == null) {  // tim k thay
				request.setAttribute("error", "Username or email are incorrect!!");
			}else {  // dung noi dung chi tiet mail
				Email email = new Email();
				email.setFrom("vuthpd06907@fpt.edu.vn");
				email.setFromPassword("thvaptx4869");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("You are userd the forgot password function. <br>");
				sb.append("Your password is <b>").append(user.getPassword()).append("</b>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);  // gui toi h.thu n.dung
				
				request.setAttribute("message", "Email sent to the email Address. "
						+ " Please check get your password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}	
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
	}

}
