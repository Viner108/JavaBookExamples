package org.example.BWandBR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderRunner {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test1/notes4.txt"))) {
            int c;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        read();
    }

    public static void read() {
        try (BufferedReader br = new BufferedReader(new FileReader("test1/notes4.txt"))) {
            String s;
            System.out.println("");
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
