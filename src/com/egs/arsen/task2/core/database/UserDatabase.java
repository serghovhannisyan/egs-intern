package com.egs.arsen.task2.core.database;


import com.egs.arsen.task2.core.model.User;
import com.egs.arsen.task2.core.util.FileUtil;
import com.egs.arsen.task2.core.util.FileUtilImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * comments
 */
public class UserDatabase implements Database
{
	private static final List<User> userDatabase = new ArrayList<>();
	private static final FileUtil FILE_RW = new FileUtilImpl();
	
	@Override
	public void saveUser(User user)
	{
		userDatabase.add(user);
	}
	
	@Override
	public void deleteUser(User user)
	{
		if (userDatabase.removeIf(user::equals)) {
			System.out.println("User successfully deleted...");
		}
		else {
			System.out.println("No such user found");
		}
	}
	
	@Override
	public List<User> getAll()
	{
		return userDatabase;
	}
	
	@Override
	public void saveAllOnExit()
	{
		FILE_RW.writeUsersToFile(userDatabase);
	}
	
	@Override
	public void initDatabaseOnStart()
	{
		userDatabase.addAll(FILE_RW.readUsersFromFile());
	}
}
