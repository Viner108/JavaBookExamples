package org.example.BISandBOS;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

public class BufferedInputStreamRunner {
    public static void main(String[] args) {
        String text = "Hello world!";
        byte[] buffer = text.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buffer);
        try (BufferedInputStream bis = new BufferedInputStream(in)) {
            int c;
            while ((c = bis.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
