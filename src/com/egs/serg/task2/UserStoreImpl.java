package com.egs.serg.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserStoreImpl implements UserStore {

    private static final String FILE_PATH = "users.txt";
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void load() {
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<User> userList = (List<User>) ois.readObject();
            ois.close();

            System.out.println("Loaded total: " + userList.size() + " users from file!!!");

            users.addAll(userList);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void get() {
        System.out.println("Enter user ID: ");
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();

        User user = null;
        for (User u : users) {
            if (u.id == id) {
                user = u;
                break;
            }
        }

        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User was not found by id: " + id);
        }
    }

    @Override
    public void add() {
        System.out.println("Enter name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Enter age");
        int age = scanner.nextInt();

        User user = new User(IdGenerator.nextId(), name, age);

        System.out.println("You added user successfully, you id is : " + user.id);

        users.add(user);
    }

    @Override
    public void remove() {
        System.out.println("Enter user ID: ");
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();

        User user = null;
        for (User u : users) {
            if (u.id == id) {
                user = u;
                break;
            }
        }

        if (user != null) {
            users.remove(user);
            System.out.println("User by id: " + id + " is deleted");
        } else {
            System.out.println("User was not found by id: " + id);
        }
    }


    @Override
    public void exit() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();

            System.out.println("Total : "+users.size()+" users are added to file successfully");
            System.out.println("Application exit successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void list() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void startProgram() {
        load();

        boolean isExit = false;

        Command.printCommands();

        while (!isExit) {
            System.out.println("Enter a command: ");

            Scanner scanner = new Scanner(System.in);
            String commandName = scanner.nextLine();
            if (commandName.equals("")) {
                continue;
            }

            Command command = Command.findCommand(commandName);

            if (command == null) {
                System.out.println("invalid command name :" + commandName);
                Command.printCommands();
                continue;
            }

            switch (command) {
                case ADD:
                    add();
                    break;
                case GET:
                    get();
                    break;
                case REMOVE:
                    remove();
                    break;
                case LIST:
                    list();
                    break;
                case EXIT:
                    exit();
                    isExit = true;
            }
        }
    }
}