package com.egs.nikol.task2;

public class User {

    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }



    @Override
    public String toString() {
        return name+","+surname+","+age;
    }
}
