package com.info.DAO.impl;

import java.util.List;

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

import com.info.DAO.ProductDao;
import com.info.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();;
	Session session;

	public ProductDaoImpl() {

	}

	public void addProduct(Product product) {
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(product); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}
	}

	public Long getTotalProductRecs() {
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Product.class);

			Long totalRecords = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

			return totalRecords;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			
		}
		return null;
	}

	public List<Product> getAllProducts(int from, int to){
		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			from = (from - 1) * to ;
			
			Criteria criteria = session.createCriteria(Product.class).addOrder(Order.desc("pid"));
			criteria.setFirstResult(from);
			criteria.setMaxResults(to);

			List<Product> listProduct= criteria.list();



			tx.commit();			

			return listProduct;

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}

		return null;

	}
	
	public List<Product> getSimilarProducts(int from, int to, int cid){
	//	SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Product.class)
				    .add(Restrictions.eq("cid",cid));
			criteria.addOrder(Order.desc("pid"));
			criteria.setMaxResults(to);

			List<Product> listProduct= criteria.list();

			tx.commit();			

			return listProduct;

		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}

		return null;

	}

	public Product getProductById(int pid) {

	//	SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();		
		Transaction tx = null;
		Product product = new Product();
		try{
			Criteria criteria = session.createCriteria(Product.class)
					.add(Restrictions.eq("pid", pid));

			Object result = criteria.uniqueResult();
			if (result != null) {
				product = (Product) result;
			}

			return product;

		} catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}

		return null;
	}

	public void updateProduct(Product product) {

		//SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(product); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}
	}

	public void deleteProduct(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		Transaction tx = null;
		try{
			Product product = new Product();
			tx = session.beginTransaction();
			product.setPid(id);
			session.delete(product); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}
	}
}
