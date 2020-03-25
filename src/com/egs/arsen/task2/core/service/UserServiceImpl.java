package com.egs.arsen.task2.core.service;


import com.egs.arsen.task2.core.database.Database;
import com.egs.arsen.task2.core.database.UserDatabase;
import com.egs.arsen.task2.core.model.User;

import java.util.List;

/**
 *
 */
public class UserServiceImpl implements UserService
{
	private Database userDb = new UserDatabase();
	
	@Override
	public void addUser(User user)
	{
		userDb.saveUser(user);
	}
	
	@Override
	public void removeUser(User user)
	{
		userDb.deleteUser(user);
	}
	
	@Override
	public List<User> getAllUsers()
	{
		return userDb.getAll();
	}
	
	@Override
	public void saveAllUsersOnExit()
	{
		userDb.saveAllOnExit();
	}
	
	@Override
	public void initUserDatabaseOnStart()
	{
		userDb.initDatabaseOnStart();
	}
}
