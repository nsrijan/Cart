package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.DAO.UserDao;
import com.info.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public void add(User user) {
		userDao.add(user);
	}

	public void edit(User user) {
		userDao.edit(user);
	}

	public void delete(int userId) {
		userDao.delete(userId);
	}

	public User getUserByName(String username, String password) {
		return userDao.getUserByName(username, password);
		 
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}
