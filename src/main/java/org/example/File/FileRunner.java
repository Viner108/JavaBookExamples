package org.example.File;

import java.io.File;
import java.io.IOException;

public class FileRunner {
    public static void main(String[] args) {
        File myFile = new File("D://work//projects//StreamApi//JavaBookExamples//test1//Notes.txt");
        System.out.println("File name: " + myFile.getName());
        System.out.println("Parent folder: " + myFile.getParent());
        if (myFile.exists()) {
            System.out.println("File exists");
        } else {
            System.out.println("File not found");
        }
        System.out.println("File size: " + myFile.length());
        if (myFile.canRead()) {
            System.out.println("File can be read");
        } else {
            System.out.println("File can not be read");
        }
        if (myFile.canWrite()) {
            System.out.println("File can be written");
        } else {
            System.out.println("File can not be written");
        }
        File newFile = new File("D://work//projects//StreamApi//JavaBookExamples//test1//MyFile");
        try {
            boolean created = newFile.createNewFile();
            if (created) {
                System.out.println("File has been created");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
