package com.info.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.UserDao;
import com.info.model.Category;
import com.info.model.Product;
import com.info.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();;
	Session session;
	
	public void add(User user) {

		session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(user); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}
	}

	public void edit(User user) {

		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(user); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}

	}

	public void delete(int userId) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try{
			User user = new User();
			tx = session.beginTransaction();
			user.setUid(userId);
			session.delete(user); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}
	}



	public User getUserByName(String username, String password) {
		
		session = factory.openSession();		
		Transaction tx = null;
		User user = new User();
		try{
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.and(Restrictions.eq("username", username),
							Restrictions.eq("password", password)));

			Object result = criteria.uniqueResult();
			if (result != null) {
				user = (User) result;
			}

			return user;

		} catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}

		return null;
		
	}

	public List<User> getAllUser() {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<User> userList = session.createCriteria(User.class).list();

			tx.commit();
			
			return userList;

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

		return null;
	}

}
