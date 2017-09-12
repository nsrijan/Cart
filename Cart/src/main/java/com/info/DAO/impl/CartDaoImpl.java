package com.info.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.info.DAO.CartDao;
import com.info.model.Cart;
import com.info.model.Product;

public class CartDaoImpl implements CartDao {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();;
	Session session;

	public void addToCart(Cart cart) {

		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(cart); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}

	}

	public List<Cart> getCartDetails(int uid, int from, int to) {

		session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			
			Criteria criteria = session.createCriteria(Cart.class).addOrder(Order.desc("id"));
			criteria.setFirstResult(from);
			criteria.setMaxResults(to);

			List<Cart> listCart= criteria.list();



			tx.commit();			

			return listCart;

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}

		return null;
	}
}
