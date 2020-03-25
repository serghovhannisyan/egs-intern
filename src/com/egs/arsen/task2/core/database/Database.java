package com.egs.arsen.task2.core.database;


import com.egs.arsen.task2.core.model.User;

import java.util.List;

/**
 * comments
 */
public interface Database
{
	void saveUser(User user);
	
	void deleteUser(User user);
	
	List<User> getAll();
	
	void saveAllOnExit();
	
	void initDatabaseOnStart();
}
