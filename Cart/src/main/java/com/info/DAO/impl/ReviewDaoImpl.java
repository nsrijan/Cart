package com.info.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.ReviewDao;
import com.info.model.CustomerReview;
import com.info.model.Product;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	
	private static SessionFactory factory;
	Session session;
	
		

	public void addCustomerReview(CustomerReview customerReview) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();	
		
		try {

			Transaction tx = session.beginTransaction();
			session.save(customerReview);
			tx.commit();

			session.close();

		} catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}

	}

	//@Transactional
	public List<CustomerReview> getAllReviews() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		try {

			Transaction tx = session.beginTransaction();

			List<CustomerReview> listReviews = session.createCriteria(CustomerReview.class).list();
			tx.commit();			
			
			return listReviews;
			
		}catch (Throwable ex) { 
			System.err.println("Failed to create sessionFactory object." + ex);
			
		}finally {
			session.close();
		}
		return null;
	}
	
	public Long getTotalReviewRecs() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(CustomerReview.class);

			Long totalRecords = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

			return totalRecords;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			
		}
		return null;
	}


}
