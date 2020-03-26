package com.egs.arev.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static String PATH = "src\\com\\egs\\arev\\task2\\users.txt";
    private static ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        readFromFile(PATH);
        readFromScreen();
    }

    public static void readFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String result = "";
            String line = reader.readLine();
            while (line != null) {
                result += line;
                line = reader.readLine();
            }
            String[] s1 = result.split(",");

            for (String item : s1) {
                String age = (item.split(" "))[1];
                String username = (item.split(" "))[0];
                User u = new User(username, Integer.parseInt(age));
                users.add(u);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromScreen() {
        System.out.println("\nHi !\n" +
                "Please select command: ADD,LIST,REMOVE,EXIT\n" +
                "for adding user:ADD username age\n" +
                "for showing all users:LIST\n" +
                "for removing:REMOVE username age\n" +
                "for exiting and saving changes:EXIT\n"
        );
        Scanner sc = new Scanner(System.in);
        String[] inputLine = {""};
        String line;
        while (!inputLine[0].equals("EXIT")) {
            line = sc.nextLine();
            inputLine = line.split(" ");
            switch (inputLine[0].toUpperCase()) {
                case "ADD": {
                    if (checkInput(inputLine))
                        System.out.println("Wrong input.Please read again requirments.");
                    else {
                        int count = 0;
                        for (User u : users) {
                            if (u.getAge() == Integer.parseInt(inputLine[2]) && (u.getUsername()).equals(inputLine[1]))
                                count++;
                        }
                        if (count == 0) {
                            users.add(new User(inputLine[1], Integer.parseInt(inputLine[2])));
                            System.out.println("You add user succesfully!Please use LIST command to see all users.");
                        } else
                            System.out.println("This user already exists in the list.Please try add other user.");
                    }
                    break;
                }

                case "LIST": {
                    for (User u : users) {
                        System.out.println(u);
                    }
                    break;
                }

                case "REMOVE": {
                    Iterator<User> iter = users.iterator();
                    int count = 0;
                    if (checkInput(inputLine)) {
                        System.out.println("Wrong input.Please read again requirments.");
                    } else {
                        while (iter.hasNext()) {
                            User u = iter.next();
                            if (u.getUsername().equals(inputLine[1]) && u.getAge() == Integer.parseInt(inputLine[2])) {
                                iter.remove();
                                count++;
                                System.out.println("You have removed the user ! Please use LIST command to see all users.");
                            }
                        }
                        if (count == 0)
                            System.out.println("This user does not exist in the list.Please try again!");
                    }
                }
                case "EXIT": {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, false))) {
                        for (User u : users) {
                            writer.write(u.getUsername() + " " + u.getAge() + ",");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }

                default: {
                    System.out.println("Please enter the correct command!");
                }
            }
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean checkInput(String[] array) {
        if (!(array.length == 3) || !isInteger(array[2]) || (Integer.parseInt(array[2])) < 0)
            return true;
        return false;
    }
}