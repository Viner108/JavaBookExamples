package org.example.BAISandBAOS;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class ByteArrayOutputStreamRunner {
    private static Path path = Path.of("test1", "hello.txt");
    private static Path pathCopy = Path.of("test1", "helloCopy.txt");
    private static String text = "Hello Wolrd!";
    private static String text2 = "Wow";

    public static void main(String[] args) {
        write();
        writeFile();
//        insertInTheMiddleFile(1);
//        replacementInTheMiddleFile(1);
    }

    private static void write() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello Wolrd!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(baos.toString());
        byte[] array = baos.toByteArray();
        for (byte b : array) {
            System.out.print((char) b);
        }
        System.out.println();
    }


    public static void writeFile() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello Wolrd!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream("test1/hello.txt")) {
            baos.writeTo(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertInTheMiddleFile(int k) {
        try (FileInputStream fis = new FileInputStream(path.toFile()); FileOutputStream fos = new FileOutputStream(pathCopy.toFile())) {
            byte[] bytes = new byte[1];
            int j;
            int byte1 = 0;
            while ((j = fis.read(bytes)) != -1 && byte1 < k) {
                fos.write(bytes, 0, j);
                byte1++;
            }
            fos.write(text2.getBytes());
            FileInputStream fis2 = new FileInputStream(path.toFile());
            byte[] bytes1 = new byte[(int) path.toFile().length()];
            while ((j = fis2.read(bytes1)) != -1) {
                fos.write(bytes1, byte1, (int) path.toFile().length() - byte1);
            }
            fis2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream(pathCopy.toFile()); FileOutputStream fos = new FileOutputStream(path.toFile())) {
            byte[] bytes = new byte[1024];
            int j;
            while ((j = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, j);
            }
            System.out.println("!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void replacementInTheMiddleFile(int i) {
        try (FileInputStream fis = new FileInputStream(path.toFile()); FileOutputStream fos = new FileOutputStream(pathCopy.toFile())) {
            byte[] bytes = new byte[1];
            int j;
            int byte1 = 1;
            while ((j = fis.read(bytes)) != -1 && byte1 <= i) {
                fos.write(bytes, 0, j);
                byte1++;
            }
            fos.write(text2.getBytes());
            FileInputStream fis2=new FileInputStream(path.toFile());
            byte[] bytes1=new byte[(int) path.toFile().length()];
            while ((j = fis2.read(bytes1)) != -1) {
                fos.write(bytes1, byte1+text2.length()-1, (int) path.toFile().length()-byte1-text2.length()+1);
            }
            fis2.close();
            System.out.println("!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream(pathCopy.toFile()); FileOutputStream fos = new FileOutputStream(path.toFile())) {
            byte[] bytes = new byte[1024];
            int j;
            while ((j = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, j);
            }
            System.out.println("!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
