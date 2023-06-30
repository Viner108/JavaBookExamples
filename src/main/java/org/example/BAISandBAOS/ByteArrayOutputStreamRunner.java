package org.example.BAISandBAOS;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class ByteArrayOutputStreamRunner {
    public static void main(String[] args) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello Wolrd!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(baos.toString());
        byte[] array = baos.toByteArray();
        for (byte b : array) {
            System.out.print((char) b);
        }
        System.out.println();
        writeFile();
    }

    public static void writeFile() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello Wolrd!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream("test1/hello.txt")) {
            baos.writeTo(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
