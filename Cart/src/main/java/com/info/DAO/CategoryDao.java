package com.info.DAO;

import java.util.List;

import com.info.model.Category;

public interface CategoryDao {
	
	void addCategory(Category cat);
	List<Category> listCategory();
	void updateCategory(Category category);
	void deleteCategory(Integer id);
	Category getCategoryById(int cid);
	Long getTotalCategoryRecs();
	

}
