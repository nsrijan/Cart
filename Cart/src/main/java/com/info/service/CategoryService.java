package com.info.service;

import java.util.List;

import com.info.model.Category;
import com.info.model.Product;

public interface CategoryService {
	List<Category> addCategory(Category p);
	List<Category> updateCategory(Category category);
	List<Category> deleteCategory(Integer id);
	List<Category> listCategory();
	Category getCategoryById(int cid);
	Long getTotalCategoryRecs();
	
}
