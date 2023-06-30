package org.example.BWandBR;

import java.io.*;

public class BufferedReaderConsole {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("test1/notes5.txt"))) {
            String text;
            while (!(text = br.readLine()).equals("ESC")) {
                bw.write(text + "\n");
                bw.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
