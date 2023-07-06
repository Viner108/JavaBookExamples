package org.example.OOSandOIS;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;

public class ObjectOutputStreamRunner {
    private static Path path = Path.of("test1", "Person.dat");

    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            Person p = new Person("Sam", 33, 178, true);
            oos.writeObject(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Person implements Serializable {

    private String name;
    private int age;
    private double height;
    private boolean married;

    Person(String n, int a, double h, boolean m) {

        name = n;
        age = a;
        height = h;
        married = m;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getHeight() {
        return height;
    }

    boolean getMarried() {
        return married;
    }
}

