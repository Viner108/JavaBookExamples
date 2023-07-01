package org.example.FOSandFIS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileInputStreamRunner {
    private static Path path = Path.of("test1", "Text.txt");

    public static void main(String[] args) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(path.toFile());
            int i;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        read();
//        System.out.println("Hello");
    }

    public static void read() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path.toFile());
            byte[] buffer = new byte[256];
            int count;
            while ((count = fileInputStream.read(buffer)) != -1) {

                for (int i = 0; i < count; i++) {
                    System.out.print((char) buffer[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
