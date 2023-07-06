package org.example.OOSandOIS;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;

public class ObjectInputStreamRunner {
    private static Path path = Path.of("test1", "Person.dat");

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Person p = (Person) ois.readObject();
            System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
