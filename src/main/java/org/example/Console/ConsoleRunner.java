package org.example.Console;

import java.io.Console;

public class ConsoleRunner {
    public static void main(String[] args) {
        Console console = System.console();
        if(console!=null){
            String login = console.readLine("Введите логин:");
            char[] password = console.readPassword("Введите пароль:");
            console.printf("Введенный логин: %s \n", login);
            console.printf("Введенный пароль: %s \n", new String(password));
        }
    }
}
