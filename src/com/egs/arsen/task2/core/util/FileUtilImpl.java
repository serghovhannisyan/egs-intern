package com.egs.arsen.task2.core.util;


import com.egs.arsen.task2.core.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FileUtilImpl implements FileUtil
{
	File file = new File("UserList.txt");
	
	@Override
	public List<User> readUsersFromFile()
	{
		checkFile();
		List<User> userResult = new ArrayList<>();
		String str;
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((str = reader.readLine()) != null)
			{
				String[] nameAge = str.split(" ",2);
				userResult.add(new User(nameAge[0], Integer.parseInt(nameAge[1])));
			}
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			//LOG
		}
		return userResult;
	}
	
	@Override
	public void writeUsersToFile(List<User> users)
	{
		checkFile();
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
			for (User u : users)
			{
				writer.write(u.getName() + " " + u.getAge());
				writer.write(System.lineSeparator());
			}
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void checkFile()
	{
		if (!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
			
		}
		
		
	}
}
