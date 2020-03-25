package com.egs.arev.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String PATH = "users.txt";
    private static ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        readFromFile(PATH);
        readFromScreen();
    }

    public static void readFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
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
        String[] checkArray = {""};
        String line;
        while (!checkArray[0].equals("EXIT")) {
            line = sc.nextLine();
            checkArray = line.split(" ");
            switch (checkArray[0].toUpperCase()) {
                case "ADD": {
                    if (check(checkArray))
                        System.out.println("Wrong input.Please read again requirments.");
                    else {
                        int count = 0;
                        for (User u : users) {
                            if (u.getAge() == Integer.parseInt(checkArray[2]) && (u.getUsername()).equals(checkArray[1]))
                                count++;
                        }
                        if (count == 0) {
                            users.add(new User(checkArray[1], Integer.parseInt(checkArray[2])));
                            System.out.println("You add user succesfully!Please use LIST command to see all users.");
                        } else
                            System.out.println("This user already exists in the list.Please try add other user.");
                    }
                    break;


                }
                case "LIST": {
                    for (User u : users) {
                        System.out.println(u);

                   "Arev".charAt(0);

                    }
                    break;
                }
                case "REMOVE": {
                    if (check(checkArray))
                        System.out.println("Wrong input.Please read again requirments.");
                    else
                        for (User u : users) {
                            if (u.getUsername().equals(checkArray[1]) && u.getAge() == Integer.parseInt(checkArray[2])) {
                                users.remove(u);
                                System.out.println("You have removed the user ! Please use LIST command to see all users.");
                                break;
                            } else
                                System.out.println("This user does not exist in the list.Please try again!");
                            break;
                        }
                    break;
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

    public static Boolean check(String[] array) {
        if (!(array.length == 3) || !isInteger(array[2]) || (Integer.parseInt(array[2])) < 0)
            return true;
        return false;
    }
}