package com.info.DAO.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.OrdersDao;
import com.info.model.Orders;

@Repository
@Transactional
public class OrdersDaoImpl implements OrdersDao {

	private static SessionFactory factory;
	Session session;

	public void addOrder(Orders order1) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(order1);
			tx.commit();

		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}


	}

	public List<Orders> getAllOrders() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Orders> ordersList = session.createCriteria(Orders.class).addOrder(Order.desc("oid")).list();
			tx.commit();			

			return ordersList;

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

		return null;

	}

	public Long getTotalOrdersRecs() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Orders.class);

			Long totalRecords = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

			return totalRecords;

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return null;
	}

	public List<Orders> orderByDate(String date) {
		/*SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.like("date","%"+date+"%"));
			
//			Query query = (Query) session.createQuery("from orders where to_char(birthDate,'YYYY-MM') =" + date);
			
		//	List<Orders> orders= (List<Orders>)query.list();
		
			return orders;
			
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close(); 
		}
		*/
		return null;
	}




}
