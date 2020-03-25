package com.egs.arsen.task2.core;


import com.egs.arsen.task2.core.exceptions.InvalidInputException;
import com.egs.arsen.task2.core.model.User;
import com.egs.arsen.task2.core.service.UserService;
import com.egs.arsen.task2.core.service.UserServiceImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
	private static final String START_COMMAND = "start";
	private static final String EXIT_COMMAND = "exit";
	private static final String INFO_COMMAND = "info";
	private static final String ADD_COMMAND = "add";
	private static final String REMOVE_COMMAND = "remove";
	private static final String GET_ALL_COMMAND = "all";
	private final static UserService userService = new UserServiceImpl();
	private static Scanner SCANNER = new Scanner(System.in);
	
	public static void start() {
		userService.initUserDatabaseOnStart();
		System.out.println();
		System.out.println("Hello and welcome to user database, use 'info' command to see all available commands");
		
		for (; ; ) {
			
			String inputCommand = SCANNER.nextLine();
			checkCommandOnStart(inputCommand);
			
		}
	}
	
	private static void getProgramInfo() {
		System.out
				.println(" Hello you can <add> <remove> <exit> <all> commandes \n " +
						 "add- you can with this method add user \n " +
						 "remove - you can with this command remove user \n " +
						 "exit- with this method you can close this program \n " +
						 "all- yoc can see all the users from db");
	}
	
	private static void checkCommandOnStart(String command) {
		switch (command) {
			case "start":
				startProgram();
				break;
			case "exit":
				exitProgram();
				break;
			case "info":
				getProgramInfo();
				break;
			default:
				try {
					throw new InvalidInputException("Wrong Input, try command 'info'...");
				}
				catch (InvalidInputException e) {
					System.out.println(e.getMessage());
				}
		}
	}
	
	private static void checkCommandAfterStart(String command) {
		switch (command) {
			case "add":
				addUser();
				break;
			case "remove":
				removeThisUser();
				break;
			case "all":
				allUsers();
				break;
			case "exit":
				exitProgram();
				break;
			case "info":
				getProgramInfo();
				break;
			default:
				try {
					throw new InvalidInputException("Invalid input try this: add, remove, all...");
				}
				catch (InvalidInputException e) {
					System.out.println(e.getMessage());
				}
		}
	}
	
	private static void startProgram() {
		System.out.println("Use commands: add, remove or all for managing users...");
		System.out.println("now you can access to user database");
		for (; ; ) {
			System.out.println("Please write a command...");
			String command = SCANNER.nextLine();
			checkCommandAfterStart(command);
			SCANNER = new Scanner(System.in);
		}
	}
	
	private static void exitProgram() {
		userService.saveAllUsersOnExit();
		System.exit(0);
	}
	
	private static void allUsers() {
		System.out.println(Arrays.toString(userService.getAllUsers().toArray()).replaceAll("[ \\[\\]*,]", ""));
	}
	
	private static void removeThisUser() {
		System.out.println("please write user name which will be deleted ");
		String name = SCANNER.nextLine();
		System.out.println("Please enter user age");
		int age = SCANNER.nextInt();
		userService.removeUser(new User(name, age));
	}
	
	private static void addUser() {
		System.out.println("Please enter user name");
		String name = SCANNER.nextLine();
		System.out.println("Please enter user age");
		int age = SCANNER.nextInt();
		userService.addUser(new User(name, age));
		
	}
	
}
