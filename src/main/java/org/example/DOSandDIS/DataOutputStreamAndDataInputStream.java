package org.example.DOSandDIS;

import java.io.*;

public class DataOutputStreamAndDataInputStream {
    public static void main(String[] args) {
        Person valeria = new Person("Valeria", 21, 1.65, false);
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("test1/data.bin"))) {
            dos.writeUTF(valeria.name);
            dos.writeInt(valeria.age);
            dos.writeDouble(valeria.height);
            dos.writeBoolean(valeria.married);
            System.out.println("File has been written");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (DataInputStream dos = new DataInputStream(new FileInputStream("test1/data.bin"))) {
            String name = dos.readUTF();
            int age = dos.readInt();
            double height = dos.readDouble();
            boolean married = dos.readBoolean();
            System.out.printf("Name: %s  Age: %d  Height: %f  Married: %b",
                    name, age, height, married);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class Person {
    public String name;
    public int age;
    public double height;
    public boolean married;

    public Person(String n, int a, double h, boolean m) {
        this.name = n;
        this.height = h;
        this.age = a;
        this.married = m;
    }
}
