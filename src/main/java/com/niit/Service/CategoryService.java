package com.niit.Service;

import java.util.List;

import com.niit.model.Category;

public interface CategoryService {
	public List<Category> getCategoryList();

	public boolean createCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
	public Category getCategoryById(int categoryId);
	
	public List<Category> getCategoryByName(String categoryname);
	

}
