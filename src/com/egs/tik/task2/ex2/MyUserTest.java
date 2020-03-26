package com.egs.tik.task2.ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.egs.tik.task2.ex2.MyUser.readWithFile;


public class MyUserTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Input function name (add,remove,list,exit)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        try {
            File f = new File("users.txt");
            if (f.createNewFile()) {
                System.out.println("File users.txt is created");
            } else {
                readWithFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            if(!(s.equals("exit"))) {
                MyUser.functionName(s);
                s = bufferedReader.readLine();
            }
            else{
                MyUser.functionName(s);
                break;
            }

        }
        bufferedReader.close();
    }
}
