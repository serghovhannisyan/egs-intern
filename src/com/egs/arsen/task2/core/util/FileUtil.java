package com.egs.arsen.task2.core.util;

import com.egs.arsen.task2.core.model.User;

import java.util.List;

/**
 *
 */
public interface FileUtil
{
	List<User> readUsersFromFile();
	
	void writeUsersToFile(List<User> users);
}
