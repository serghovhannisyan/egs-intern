package task2;

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
            writeFile();
        } catch (Exception e) {
            System.out.println("Error during read/write: " + e.getMessage());
        }
    }

    private void readFile() throws IOException, ClassNotFoundException {
        try (BufferedReader bRid = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = bRid.readLine()) != null) {
                String[] userNameAndAge = str.split(" ");
                users.add(new User(userNameAndAge[0], Integer.parseInt(userNameAndAge[1])));
            }
        }
    }

    private void writeFile() throws IOException {
        System.out.println("\nselect <command(ADD,REMOVE,LIST or EXIT)\n" +
                "for <add> select :ADD space age: \n" +
                "for <remove> select :REMOVE space Index(n): \n" +
                "for <Print> select only: LIST:\n" +
                "for <exit and Save> select only :EXIT:\n" +
                "for <support> select only :HELP:\n" +
                "for <clear> select only :CLEAR:");
        Scanner scanner = new Scanner(System.in);
        String line;
        String[] array = {""};
        while (!array[0].equals("EXIT")) {
            System.out.println("\nInput command");
            line = scanner.nextLine();
            array = line.split(" ");
            switch (array[0].toUpperCase()) {
                case "ADD": {
                    users.add(new User(array[1], Integer.parseInt(array[2])));
                    System.out.println("user added");
                    break;
                }
                case "REMOVE": {
                    if (array.length < Integer.parseInt(array[1])) {
                        throw new IllegalArgumentException("Index can not be small array.length");
                    }
                    users.remove(Integer.parseInt(array[1]));
                    System.out.println("user removed");
                    break;
                }
                case "LIST": {
                    for (User user : users) {
                        System.out.println(user.getName() + " " + user.getEge());
                    }
                    break;
                }
                case "HELP": {
                    System.out.println("\nselect <command(ADD,REMOVE,LIST or EXIT)\n" +
                            "for <add> select :ADD space age: \n" +
                            "for <remove> select :REMOVE space Index(n): \n" +
                            "for <Print> select only: LIST:\n" +
                            "for <exit and Save> select only :EXIT:\n" +
                            "for <clear> select only :CLEAR:");
                    break;
                }
                case "CLEAR": {
                    users.clear();
                    file.delete();
                    System.out.println("users list has be clear");
                    break;

                }

                default: {
                    if (array[0].equals("EXIT")) {
                        break;
                    }
                    System.out.println("Input correct arguments:");
                    break;
                }

            }
            if (line.equalsIgnoreCase("EXIT")) {
                try (BufferedWriter bWrit = new BufferedWriter(new FileWriter(file))) {
                    for (User user : users) {
                        bWrit.write(user.getName() + " " + user.getEge() + "\n");
                    }
                }

            }
        }
    }
}
