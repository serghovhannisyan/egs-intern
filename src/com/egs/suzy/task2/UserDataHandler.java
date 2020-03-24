import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.*;

public class UserDataHandler {
    private static final String[] COMMANDS = {"Add", "Remove", "List", "Exit"};
    private static final int MAX_INCORRECT_INPUT = 3;
    private static ArrayList<User> users = new ArrayList<>();;

    UserDataHandler() throws IOException {
       this(new File("users.txt"));
    }

    UserDataHandler(File userStorage) throws IOException {
      /*  Runtime rs = Runtime.getRuntime();
        File editFile = new File("input.txt");
        try {
            editFile.createNewFile();
            rs.exec("notepad.exe input.txt");
        }
        catch (IOException e) {
            System.out.println(e);
        }*/
        if(userStorage.exists() && (userStorage.length()>0)) {
            getUsersFromFile(userStorage);
        }
        commandListener();
     }

    private void commandListener() throws IOException {
        System.out.println("Please specify one of the commands: ADD, REMOVE, LIST or EXIT!");
        String line;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
             line = reader.readLine().toUpperCase();
             outer:
            while (true) {
                switch (line) {
                    case "ADD":
                        int inputAge, counter = 0;
                        String inputUserName;
                        System.out.println("Add username");
                        inputUserName = reader.readLine();
                        try {
                            while (!isUsernameUnique(inputUserName) && counter < MAX_INCORRECT_INPUT) {
                                System.out.println("This username is taken. Please, try a new one!");
                                inputUserName = reader.readLine();
                                counter++;
                            }
                        } catch (IOException e) {
                            System.out.println("You exceed the limit of wrong inputs");
                        }
                        counter = 0;
                        System.out.println("Add age");
                        inputAge = Integer.parseInt(reader.readLine());
                        try {
                            while (!isValidAge(inputAge) && counter < MAX_INCORRECT_INPUT) {
                                System.out.println("This username is taken. Please, try a new one!");
                                inputAge = Integer.parseInt(reader.readLine());
                                counter++;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                       users.add(new User(inputUserName, inputAge));
                        break;
                    case "REMOVE":
                        System.out.println("Please type username for removal");
                        inputUserName = reader.readLine();
                        int i = findUser(inputUserName);
                        if(i != -1){
                            users.remove(i);
                            System.out.println("Successfully removed");
                        }
                           else System.out.println("Username doesn't exist. Type a new command!");
                           break;
                    case "LIST":
                        for (User u : users)
                            System.out.println("name = " + u.getUsername() + "  age = " + u.getAge());
                        break;
                    case "EXIT":
                        File storage = new File("users.txt");
                        storage.createNewFile();
                        saveUsersIntoFile(storage);
                        break outer;
                }
                line = reader.readLine().toUpperCase();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static boolean isUsernameUnique(String username) {
        if (findUser(username) == -1) return true;
        return false;
    }

    private static boolean isCommand(String input) {
        for (String x : COMMANDS) {
            if (input.equalsIgnoreCase(x)) return true;
        }
        return false;
    }

    private static boolean isValidAge(int age) {
        if (age > 0 && age <= 130) return true;
        return false;
    }

    public static int findUser(String username) {
        if (users != null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void saveUsersIntoFile(File filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (User u : users) {
                writer.write(u.getUsername() + " " + u.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getUsersFromFile(File userStorage) {
        String[] splitLine;
        try {
            List<String> allLines = Files.readAllLines(Paths.get(String.valueOf(userStorage)));
            for (String line : allLines) {
                splitLine = line.split(" ");
                users.add(new User(splitLine[0], Integer.parseInt(splitLine[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
