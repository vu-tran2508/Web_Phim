package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.model.User;

@WebServlet({"/UserManagement", "/Admin/UserManagement", "/Admin/UserManagement/create",
	"/Admin/UserManagement/update","/Admin/UserManagement/delete",
	"/Admin/UserManagement/resert", "/Admin/UserManagement/edit", })
@MultipartConfig
public class UsersManagementServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString(); 
		if (url.contains("edit")) { 
			edit(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("resert")) {
			resert(request, response);
			return;
		}

		User user = new User(); 
		findAll(request, response);

		request.setAttribute("user", user);

		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("resert")) {
			resert(request, response);
			return;
		}
	}

	private void resert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username"); 

		User user = new User();
		request.setAttribute("user", new User());

		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");

		if (id == null) {
			request.setAttribute("error", "Username is inserted");
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {

			UserDao dao = new UserDao(); 
			User user = dao.findById(id);

			if (user == null) {
				request.setAttribute("error", "username not found!!!");
				PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "user is deleted!!!"); 

			request.setAttribute("user", new User());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(); 
		try {
			BeanUtils.populate(user, request.getParameterMap());

			UserDao dao = new UserDao(); 
			User oldUser = dao.findById(user.getUsername());

			dao.update(user);

			request.setAttribute("user", user); 
			request.setAttribute("message", "user is updated!!!");
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {

		try {
			UserDao dao = new UserDao(); // tao d.tuong dao

			List<User> list = dao.findAll();

			request.setAttribute("users", list); // h.thi t.tin vua c.nhap
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("username");

		if (id == null) { // id=null
			request.setAttribute("error", "username is inserted");
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
			return;
		}
		try {

			UserDao dao = new UserDao();
			User user = dao.findById(id);

			request.setAttribute("user", user); 
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User(); 
		try {
			BeanUtils.populate(user, request.getParameterMap());

			UserDao dao = new UserDao();
			dao.insert(user);

			request.setAttribute("user", user);
			request.setAttribute("message", "user is inserted");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());

		}
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);

	}

}
