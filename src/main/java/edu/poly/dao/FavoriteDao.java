package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.model.Favorite;

public class  FavoriteDao extends AbstractEntityDao<Favorite>{

	public FavoriteDao() {
		super(Favorite.class);
	}	
	
	public List<FavoriteUserReport> reportFavoriteUsersByVideo(String videoId){ // nhap id
		
		String jpql = "select new edu.poly.domain.FavoriteUserReport(f.user.username, f.user.fullname, "
				+ "f.user.email, f.likedDate) from Favorite f where f.video.videoId = :videoId ";
		
		EntityManager em = JpaUtils.getEntityManager(); //
		
		List<FavoriteUserReport> list = null;
		
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class); // tao query
			
			query.setParameter("videoId", videoId);  // t.lap tham so
			
			list = query.getResultList();  // tra ve kq
		} finally {
			em.close();
		}
		
		return list;
	}
	 
	public List<FavoriteReport> reportFavoritesByVideo(){
		String jpql = "select new edu.poly.domain.FavoriteReport(f.video.title, count(f), min(f.likedDate), max(f.likedDate)) "
				+ " from Favorite f group by f.video.title ";
	    
		EntityManager em = JpaUtils.getEntityManager();	
		List<FavoriteReport>  list = null;
		
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class); // tao query
			
			list = query.getResultList();  // tra ve danh sach cac favorite
		} finally {
			em.close();
		}
		return list;
	}
}
