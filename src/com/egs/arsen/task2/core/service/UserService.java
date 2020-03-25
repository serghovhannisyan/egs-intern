package com.egs.arsen.task2.core.service;


import com.egs.arsen.task2.core.model.User;

import java.util.List;

/**
 * comments
 */
public interface UserService
{
	void addUser(User user);
	
	void removeUser(User user);
	
	List<User> getAllUsers();
	
	void saveAllUsersOnExit();
	
	void initUserDatabaseOnStart();
}
