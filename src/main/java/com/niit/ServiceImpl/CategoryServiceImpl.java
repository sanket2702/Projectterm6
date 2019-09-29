package com.niit.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Service.CategoryService;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
CategoryDAO categorydao;
	public List<Category> getCategoryList() {
		
		return categorydao.getCategoryList();
	}

	public boolean createCategory(Category category) {
		categorydao.createCategory(category);
		return true;
	}

	public boolean updateCategory(Category category) {
		categorydao.updateCategory(category);
		return true;
	}

	public boolean deleteCategory(Category category) {
		categorydao.deleteCategory(category);
		return true;
	}

	public Category getCategoryById(int categoryId) {
		return categorydao.getCategoryById(categoryId);
	}

	public List<Category> getCategoryByName(String categoryname) {
		return categorydao.getCategoryByName(categoryname);
	}

}
