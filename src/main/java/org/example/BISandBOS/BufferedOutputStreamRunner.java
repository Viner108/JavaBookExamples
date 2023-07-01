package org.example.BISandBOS;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class BufferedOutputStreamRunner {
    private static Path path = Path.of("test1", "notes.txt");
    private static Path pathCopy = Path.of("test1", "notesCopy.txt");
    private static String text = "Hello Wolrd!";
    private static String text2 = "Wow";
    public static void main(String[] args) {
        write();
        insertInTheMiddleFile(1);
        replacementInTheMiddleFile(1);
    }

    private static void write() {
        String text = "Hello world!";
        try (FileOutputStream out = new FileOutputStream("test1/notes.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            ex.printStackTrace();
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
