package com.niit.daoimpl;

import java.util.List;



import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.model.User;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired(required=true)
	SessionFactory sessionFactory;

	public final static Logger logger = Logger.getLogger(UserDAOImpl.class);

	public List<User> getUserList() {
		@SuppressWarnings("unchecked")
		List<User> getUserList = sessionFactory.getCurrentSession().createQuery("from User").list();
			return getUserList;
	}

	public boolean createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
			return true;
	}

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
			return true;
	}

	public User getUserById(String userId) {
		User user = (User) sessionFactory.getCurrentSession().createQuery("from User where userId = " + userId).uniqueResult();
			return user;
	}

	public boolean deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}
	@SuppressWarnings("unchecked")
	public List<User> getUserListByName(String username) {
		return (List<User>) sessionFactory.getCurrentSession().createQuery("from User where username like "+ "'%"+username + "%'").list();
		
	}

	public User authUser(String userId,String password) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userId='"+userId +"' and password='"+password+"'").uniqueResult();
	}
}
