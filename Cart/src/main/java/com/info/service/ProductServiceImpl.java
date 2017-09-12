package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.ProductDao;
import com.info.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao pdao;

	public Long getTotalProductRecs(){

		return pdao.getTotalProductRecs();

	}

	public void addProduct(Product product) {

		pdao.addProduct(product);

	}

	public List<Product> getAllProducts(int from, int to) {

		return pdao.getAllProducts(from, to);

	}

	public List<Product> getSimilarProducts(int from, int to, int cid) {

		return pdao.getSimilarProducts(from, to, cid);

	}

	public Product getProductById(int pid) {

		return pdao.getProductById(pid);

	}

	public void updateProduct(Product product) {

		pdao.updateProduct(product);		

	}

	public void deleteProduct(Integer id) {

		pdao.deleteProduct(id);	
	}

}
