package com.info.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.CategoryDao;
import com.info.model.Category;
import com.info.model.Product;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();

	public void addCategory(Category cat) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(cat); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	public Category getCategoryById(int cid) {

		Session session = factory.openSession();
		Transaction tx = null;
		Category category = new Category();
		try{
			Criteria criteria = session.createCriteria(Category.class)
					.add(Restrictions.eq("cid", new Integer(cid)));

			Object result = criteria.uniqueResult();
			if (result != null) {
				category = (Category) result;
			}

			return category;

		} catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		
		return null;
	}

	public List<Category> listCategory(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<Category> categoryList = session.createCriteria(Category.class).list();

			tx.commit();
			
			return categoryList;

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

		return null;

	}
	
	public Long getTotalCategoryRecs() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Category.class);

			Long totalRecords = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

			return totalRecords;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			
		}
		return null;
	}
	
	
	public void updateCategory(Category category) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(category); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		
	}
	
	public void deleteCategory(Integer id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			Category category = new Category();
			tx = session.beginTransaction();
			category.setCid(id);
			session.delete(category); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}

}



