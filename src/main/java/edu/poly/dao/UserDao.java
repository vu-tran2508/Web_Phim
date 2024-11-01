package edu.poly.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.hibernate.hql.internal.QueryExecutionRequestException;

import edu.poly.model.User;

public class UserDao extends AbstractEntityDao<User> {

	public UserDao() {
		super(User.class);

	}
	
	public void changePassword(String username, String oldPassword, String newPassword) throws Exception {
		
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		// tim user pass trong csdl
		String jpql = "select u from User u where u.username = :username and u.password = :password";
		
		try {
			trans.begin();
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);   // t.lap g.tri cho cac tham so
			query.setParameter("password", oldPassword);
			
			User user = query.getSingleResult();  //tra d.tuong
			
			if (user == null) {   // loi
				throw new Exception("Current password or Username are incorrect!!");				
			}
			user.setPassword(newPassword); // thay mk
			
			em.merge(user);   // tac dong thay doi
			
			trans.commit();  // hoan tat thay doi
		} catch (Exception e) {
			trans.rollback();   // huy bo
			
			throw e;
		}finally {
			em.close();
		}
	}
	
	public User findByUsernameAndEmail(String username, String email) {
		EntityManager em = JpaUtils.getEntityManager();
		
		//tim username vs email trong csdl
		String jpql= "select u from User u where u.username=:username and u.email = :email";
		
		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);  //t.lap g.tri cho cac tham so
			query.setParameter("email", email);
			
			return query.getSingleResult(); // tra user tim thay
			
		} finally {
			em.close();
		}
	}
}
