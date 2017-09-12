package com.info.service;

import java.util.List;

import com.info.model.Product;

public interface ProductService {

	void addProduct(Product product);
	List<Product> getAllProducts(int from, int to);
	List<Product> getSimilarProducts(int from, int to, int cid);
	Product getProductById(int pid);
	void updateProduct(Product product);
	void deleteProduct(Integer id);
	Long getTotalProductRecs();
}
