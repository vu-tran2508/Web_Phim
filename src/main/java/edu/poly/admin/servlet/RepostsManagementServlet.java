package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.model.Video;

/**
 * Servlet implementation class RepostsManagementServlet
 */
@WebServlet("/RepostsManagement")
public class RepostsManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		reportFavoriteByVideos(request, response);
		reportFavoriteUsersByVideo(request, response);
		
		PageInfo.prepareAndForward(request, response, PageType.REPOST_MANAGEMENT_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void reportFavoriteUsersByVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String videoUserId = request.getParameter("videoUserId"); // lay video n.dung lua chon
			
			VideoDao vdao = new VideoDao();     // lay danh sach tat ca video trong csdl
			List<Video> vList = vdao.findAll();
			
			if (videoUserId == null && vList.size()>0) {  // kt videouserid = null => n.dung ch lua chon
				videoUserId = vList.get(0).getVideoId();
			}
				
			FavoriteDao dao = new FavoriteDao(); //
			List<FavoriteUserReport> list = dao.reportFavoriteUsersByVideo(videoUserId);  // tra danh sach 
			
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("vidList", vList); 
			request.setAttribute("favUsers", list); // hien thi
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage()); 
		}
	}
	
	protected void reportFavoriteByVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			FavoriteDao dao = new FavoriteDao(); //
			List<FavoriteReport> list = dao.reportFavoritesByVideo();  // danh sach thong ke
			
			request.setAttribute("favList", list); // lay va truyen du lieu
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage()); 
		}
	}
}
