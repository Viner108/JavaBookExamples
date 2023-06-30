package org.example.FWandFR;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderRunner {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("test1/notes3.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        read();
    }

    public static void read() {
        try (FileReader reader = new FileReader("test1/notes3.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.println("");
                System.out.print(buf);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

