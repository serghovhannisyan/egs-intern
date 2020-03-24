package com.egs.serg.task2;

public enum Command {

    ADD,
    GET,
    REMOVE,
    LIST,
    EXIT;

    public static Command findCommand(String name) {
        Command command = null;

        for (Command c : values()) {
            if (c.name().equalsIgnoreCase(name)) {
                command = c;
                break;
            }
        }

        return command;
    }

    public static void printCommands() {
        System.out.println("Available commands");
        for (Command command : values()) {
            System.out.println(command);
        }
    }
}