package com.info.DAO;

import java.util.List;

import com.info.model.User;

public interface UserDao {
	
	public void add(User user);
	public void edit(User user);
	public void delete(int userId);
	public User getUserByName(String username, String password);
	public List<User> getAllUser();

}
