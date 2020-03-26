package com.egs.nikol.task2;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    private static File file;
    static {
        try {
            final URL resource = Main.class.getResource("users.txt");
            file = new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean b = true;


        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));


            while (b) {
                String str = reader.readLine();
                if (str != null) {
                    String[] s = str.split(",");
                    UserManager.add(UserManager.users, new User(s[0], s[1], Integer.parseInt(s[2])));
                } else b=false;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        commandsControl();


    }

    public static void commandsControl() {

        boolean b = true;
        while (b) {
            try {
                switch (Commands.valueOf(scanner.next().toUpperCase())) {
                    case ADD: {
                        UserManager.add();
                        break;
                    }
                    case REMOVE: {
                        UserManager.remove();
                        break;
                    }
                    case LIST: {
                        UserManager.list();
                        break;
                    }
                    case EXIT: {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                            b = UserManager.exit(writer);

                            writer.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
