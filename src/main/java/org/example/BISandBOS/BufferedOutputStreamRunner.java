package org.example.BISandBOS;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamRunner {
    public static void main(String[] args) {
        String text = "Hello world!";
        try (FileOutputStream out = new FileOutputStream("test1/notes.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
