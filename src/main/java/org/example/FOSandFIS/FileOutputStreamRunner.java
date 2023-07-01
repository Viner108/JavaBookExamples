package org.example.FOSandFIS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Date;

public class FileOutputStreamRunner {
    private static Path path = Path.of("test1", "Text.txt");
    private static Path pathCopy = Path.of("test1", "TextCopy.txt");
    private static String text = "Hello Lera!\n";
    private static String text2 = "World";

    public static void main(String[] args) {
        Date startTime = new Date();
        int i = 3;// в какое место в файле надо вставить или заменить текст при вставке одновременно text и text2
        if (i < text.length() - text2.length()) {
        } else {
            i = 0;
        }
        write(false);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        writeInTheMiddle(i);
        replacement(i);
//        insertInTheMiddleFile(3);
//        replacementInTheMiddleFile(3);
        remove(3,3);
        Date endTime = new Date();
        long totalTime = endTime.getTime() - startTime.getTime();
        System.out.println("Время: " + totalTime + " мс");
    }

    private static void write(boolean append) {
        try (FileOutputStream fos = new FileOutputStream(path.toFile(), append)) {
            byte[] buffer = text.getBytes();
            for (int i = 0; i < text.length(); i++) {
                fos.write(buffer[i]);
            }
            System.out.println("The file has been written");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void writeInTheMiddle(int i) {
        try (FileOutputStream fos = new FileOutputStream(path.toFile(), true)) {
            fos.write(text.getBytes(), 0, i);
            fos.write(text2.getBytes());
            fos.write(text.getBytes(), i, text.length() - i);
            fos.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replacement(int i) {
        try (FileOutputStream fos = new FileOutputStream(path.toFile(), true)) {
            fos.write(text.getBytes(), 0, i);
            fos.write(text2.getBytes());
            fos.write(text.getBytes(), i + text2.length(), text.length() - i - text2.length());
            fos.write("\n".getBytes());
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
            FileInputStream fis2=new FileInputStream(path.toFile());
            byte[] bytes1=new byte[(int) path.toFile().length()];
            while ((j = fis2.read(bytes1)) != -1) {
                    fos.write(bytes1, byte1, (int) path.toFile().length()-byte1);
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
    }public static void remove(int k,int r) {
        try (FileInputStream fis = new FileInputStream(path.toFile()); FileOutputStream fos = new FileOutputStream(pathCopy.toFile())) {
            byte[] bytes = new byte[1];
            int j;
            int byte1 = 0;
            while ((j = fis.read(bytes)) != -1 && byte1 < k) {
                fos.write(bytes, 0, j);
                byte1++;
            }
            while ((j = fis.read(bytes)) != -1 && byte1 < k+r) {
                fos.write(" ".getBytes());
                byte1++;
            }
            FileInputStream fis2=new FileInputStream(path.toFile());
            byte[] bytes1=new byte[(int) path.toFile().length()];
            while ((j = fis2.read(bytes1)) != -1) {
                    fos.write(bytes1, byte1, (int) path.toFile().length()-byte1);
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

}
