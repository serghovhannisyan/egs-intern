package com.egs.sargsyanarsen.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFileIntoArrayList {

    private ArrayList<User> users = new ArrayList<>();
    private File file;

    public ReadFromFileIntoArrayList(File file) {
        this.file = file;
    }

    public ReadFromFileIntoArrayList(String filePath) {
        file = new File(filePath);
    }

    public void go() {
        try {
            readFile();
        } catch (Exception e) {
            System.out.println("Error during read/write: " + e.getMessage());
        }
        try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() throws IOException, ClassNotFoundException {
        try (BufferedReader bRid = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = bRid.readLine()) != null) {
                String[] userNameAndAge = str.split(" ");
                int age;
                int id;
                try {
                    age = Integer.parseInt(userNameAndAge[1]);
                    id = Integer.parseInt(userNameAndAge[2]);
                }catch (NumberFormatException e){
                    System.out.println("age or id parse exception");
                    return;
                }
                users.add(new User(userNameAndAge[0], age, id));
            }
        }
    }

    private void writeFile() throws IOException {
        System.out.println(Constants.WELCOME_LOG_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String line;
        String[] array;
        Command command;
        do {
            System.out.println("\nInput command");
            line = scanner.nextLine();
            array = line.split(" ");
            command = Command.valueOf(array[0].toUpperCase());
            switch (command) {
                case ADD: {
                    int age;
                    int id;
                    try {
                        age = Integer.parseInt(array[2]);
                        id = Integer.parseInt(array[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("age or id pars exceptions");
                        break;
                    }
                    for (User user : users) {
                        if (user.getId() == id) {
                            System.out.println("with this id already exists user");
                            writeFile();
                        }
                    }
                    users.add(new User(array[1], age, id));
                    System.out.println("user added");
                    break;
                }
                case REMOVE: {
                    int index;
                    try {
                        index = Integer.parseInt(array[1]);
                    }catch (NumberFormatException e) {
                        System.out.println("index pars exceptions");
                        break;
                    }
                    if (users.size() < index) {
                        System.out.println("Index can not be small array.length");
                        break;
                    }
                    users.remove(index);
                    System.out.println("user removed");
                    break;
                }
                case LIST: {
                    for (User user : users) {
                        System.out.println(String.format("%s %d %d", user.getName(), user.getEge(), user.getId()));
                    }
                    break;
                }
                case HELP: {
                    System.out.println(Constants.WELCOME_LOG_MESSAGE);
                    break;
                }
                case CLEAR: {
                    users.clear();
                    file.delete();
                    System.out.println("users list has be clear");
                    break;
                }
                case EXIT: {
                    try (BufferedWriter bWrit = new BufferedWriter(new FileWriter(file))) {
                        for (User user : users) {
                            bWrit.write(String.format("%s %d %d\n", user.getName(), user.getEge(), user.getId()));
                        }
                    }
                    break;
                }
                default: {
//
                    System.out.println("Input correct arguments:");
                    writeFile();
                }
            }
        } while (command != Command.EXIT);
    }
}
