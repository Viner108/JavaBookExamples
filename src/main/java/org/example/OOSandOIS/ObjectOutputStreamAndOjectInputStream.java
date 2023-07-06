package org.example.OOSandOIS;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class ObjectOutputStreamAndOjectInputStream {
    private static Path path = Path.of("test1", "Person.dat");

    public static void main(String[] args) {
        ArrayList<Human> people = new ArrayList<>();
        people.add(new Human("Tom", 30, 175, false));
        people.add(new Human("Sam", 33, 178, true));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(people);
            System.out.println("File has been written");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ArrayList<Human> newPeople = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            newPeople = ((ArrayList<Human>) ois.readObject());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (Human p : newPeople)
            System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());
    }
}

class Human implements Serializable {

    private String name;
    private int age;
    private transient double height;
    private transient boolean married;

    Human(String n, int a, double h, boolean m) {

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
