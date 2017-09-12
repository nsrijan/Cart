package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.DAO.CategoryDao;
import com.info.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao cdao;

	public List<Category> addCategory(Category category) {
		
		cdao.addCategory(category);

		return cdao.listCategory();
		
	}

	public List<Category> updateCategory(Category category) {
		
		cdao.updateCategory(category);
		
		return cdao.listCategory();
	}

	public List<Category> deleteCategory(Integer id) {
		
		cdao.deleteCategory(id);

		return cdao.listCategory();
		
	}

	public Category getCategoryById(int cid) {
		
		return cdao.getCategoryById(cid);
		
	}

	public List<Category> listCategory() {
		
		return cdao.listCategory();
		
	}

	public Long getTotalCategoryRecs() {

		return cdao.getTotalCategoryRecs();
	}
	
	

}
