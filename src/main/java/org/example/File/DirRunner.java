package org.example.File;

import java.io.File;

public class DirRunner {
    public static void main(String[] args) {
        File dir = new File("D://work//projects//StreamApi//JavaBookExamples//test1");
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \t folder");
                } else {
                    System.out.println(item.getName() + "\t file");
                }
            }
        }
    }
}
