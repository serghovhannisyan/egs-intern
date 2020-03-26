package com.egs.arev.task2;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private int age;

    public User(String u_name, int age) {
        this.username = u_name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String u_name) {
        this.username = u_name;
    }

    public String getUsername() {
        return this.username;
    }

    public int getAge() {
        return this.age;
    }
    public String toString(){
        return new StringBuffer("Username is: ").append(this.username).append(" , Age is: ").
                append(this.age).toString();
    }

}
