package org.example.FWandFR;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterRunner {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("test1/notes3.txt", false)) {
            String text = "Hello Gold!";
            writer.write(text);
            writer.append('\n');
            writer.append('E');
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
