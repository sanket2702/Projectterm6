package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
import com.niit.model.User;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired(required=true)
	SessionFactory sessionFactory;

	public final static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	

	public boolean createCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
		return true;
		
	}

	public boolean updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return true;
	}

	public boolean deleteCategory(Category category) {
		sessionFactory.getCurrentSession().delete(category);

		return true;
	}

	public Category getCategoryById(int categoryId) {
		Category category = (Category) sessionFactory.getCurrentSession().createQuery("from category where categoryId = " + categoryId).uniqueResult();
		return category;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategoryByName(String categoryname) {
		return (List<Category>) sessionFactory.getCurrentSession().createQuery("from User where username like "+ "'%"+categoryname + "%'").list();
	}

	public List<Category> getCategoryList() {
		@SuppressWarnings("unchecked")
		List<Category> getCategoryList = sessionFactory.getCurrentSession().createQuery("from category").list();
		return getCategoryList;
	}

}
