package org.example.PSandPW;

import java.io.PrintWriter;

public class PrintWriterRunner {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(System.out)) {
            pw.println("Hello world!");
        }
    }
}
