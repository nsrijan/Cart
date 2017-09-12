package com.info.service;

import java.util.List;

import com.info.model.User;

public interface UserService {

	public void add(User user);
	public void edit(User user);
	public void delete(int userId);
	public User getUserByName(String username, String password);
	public List<User> getAllUser();
	
}
