package org.example.PSandPW;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamRunner {
    public static void main(String[] args) {
        String text = "Привет мир!";
        try (FileOutputStream fos = new FileOutputStream("D://work//projects//StreamApi//JavaBookExamples//test1//note3.txt"); PrintStream printStream = new PrintStream(fos)) {
            printStream.println(text);
            System.out.println("Запись в файл произведена");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        write();
    }

    public static void write() {
        try (PrintStream printStream = new PrintStream("test1/notes4.txt")) {
            printStream.print("Hello World!");
            printStream.println("Welcome to Java!");
            printStream.printf("Name: %s Age: %d \n", "Valeria", 21);
            String message = "PrintStream";
            byte[] message_toBytes = message.getBytes();
            printStream.write(message_toBytes);
            System.out.println("The file has been written");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
