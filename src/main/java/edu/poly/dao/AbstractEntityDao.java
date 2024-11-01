package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractEntityDao<T> {
	private Class<T> entityClass;
	
	public AbstractEntityDao(Class<T> cls) { //
		this.entityClass = cls;
	}
	
	public void insert(T entity) { // chen entity vao csdl
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.persist(entity);  //
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
			
		}finally {
			em.close();
		}
	}
	
	public void update(T entity) {  // chen entity vao csdl
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.merge(entity); //tich hop, cap nhat gia tri thay doi vao entity
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
			
		}finally {
			em.close();
		}
	}
	
	public void delete(Object id) {  // xoa dua vao id
		EntityManager em = JpaUtils.getEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			
			T entity = em.find(entityClass, id); // tim id bang cach goi find
			
			em.remove(entity); // loai bo entity
			
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
			
		}finally {
			em.close();
		}
	}
	
	public T findById(Object id) { //
		EntityManager em = JpaUtils.getEntityManager();

		T entity = em.find(entityClass, id); // tim id bang cach goi find

		return entity; // tra entity tim dc
	}
	
	public List<T> findAll() { // tra ve all
		EntityManager em = JpaUtils.getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery(); // CQ cho phep xd truy van entity class
			
			cq.select(cq.from(entityClass)); // selcect		
			return em.createQuery(cq).getResultList(); // tra ve danh sach
		} finally  {
			// TODO Auto-generated catch block
			em.close();
		}
	}
	
	public List<T> findAll(boolean all, int firstResult, int maxResult) { // xac dinh cac gia tri phan trang
		EntityManager em = JpaUtils.getEntityManager();
		Query q;
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery(); // CQ cho phep xd truy van entity class
			
			cq.select(cq.from(entityClass)); // selcect
			q = em.createQuery(cq);
			
			if (!all) { // phan trang
				q.setFirstResult(firstResult);
				q.setMaxResults(maxResult);
			}
			return q.getResultList(); // tra ve danh sach
		} finally {
			em.close();
		}
	}
	
	public Long Count() { // dem va tra ve tong so entity
		EntityManager em = JpaUtils.getEntityManager();

		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery(); // CQ cho phep xd truy van entity class
			
			Root<T> rt = cq.from(entityClass);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return (Long) q.getSingleResult();
		}finally {
			em.close();
		}	
	}
}
