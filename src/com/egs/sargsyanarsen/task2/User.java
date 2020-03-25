package com.egs.sargsyanarsen.task2;

public class User {

    private String name;
    private int ege;
    private int id;

    public User(String name, int ege,int id) {
        this.name = name;
        this.ege = ege;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getEge() {
        return ege;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", ege=" + ege +
                ", id=" + id +
                '}';
    }
}

