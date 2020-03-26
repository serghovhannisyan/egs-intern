package com.egs.tik.task2.ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyUser implements Serializable{
    public static ArrayList<String> users = new ArrayList<>();


    //MENU METHOD
    public static void functionName(String s){
        switch (s){
            case "add":{
                String values = inputNameAge();
                add(values);
                System.out.println("Input function name ( add , remove , list , exit)");
                break;
            }
            case "remove":{
                System.out.println("Input remove index");
                int index = removeIndex();
                myRemove(index);
                System.out.println("Input function name ( add , remove , list , exit)");
                break;
            }
            case "list":{
                myList();
                System.out.println("Input function name ( add , remove , list , exit)");
                break;
            }
            case "exit":{
                saveWithFile();
                break;
            }
            default:{
                System.out.println("You input wrong command,,,");
            }
        }
    }


    // ADD METHOD ////
    public static void add(String user){
        String[] us = user.split(" ");
        if(us.length == 0){
            System.out.println("You dont add name and age correctly");
        }
        else if(us.length == 1){
            System.out.println("You dont add name or age correctly");
        }
        else {
            users.add(user);
            System.out.println("You add new element");
        }
    }


    // INPUT Values METHOD ////
    public static String inputNameAge(){
        System.out.println("Input name and age with space");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



    //REMOVE METHOD ////
    public static void myRemove(int index){
        if(index>=0 && index < users.size()){
            users.remove(index);
            System.out.println("You remove value of this index = "+index);
        }
        else {
            System.out.println("List is ampty or index out of bands");
        }
    }



    //INPUT REMOVE INDEX METHOD ////
    public  static int removeIndex(){
        Scanner scanner = new Scanner(System.in);
        int index;
        index = scanner.nextInt();
        System.out.println(index);
        return index;
    }



    // LIST METHOD ////
    public static void myList(){
        if(users.size()>0) {
            printArray();
        }
        else
            System.out.println("List is empty");
    }



    //READ WITH FILE
    public  static void readWithFile(){
        //File file = new File("users.txt");
        users.clear();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"))){
            String s;
            while ((s=bufferedReader.readLine())!=null) {
                users.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // SAVE WITH FILE METHOD ////
    public static void saveWithFile() {
        //File file = new File("users.txt");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt"))){
            for (String s:users
                 ) {
                s=s.trim();
                bufferedWriter.write(s+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // METHOD PRINT ARRAY ////
    public static void printArray(){
        for (String my : users) {
            System.out.println(my);
        }
    }
}
