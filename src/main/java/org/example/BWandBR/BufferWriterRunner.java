package org.example.BWandBR;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterRunner {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("test1/notes4.txt"))) {
            String text = "Hello  World!\nHey! Teachers! Leave the kids alone.";
            bw.write(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
