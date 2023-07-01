package org.example.FOSandFIS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

public class FileOutputStreamRunner {
    private static Path path=Path.of("test1","Text.txt");
    private static Path pathCopy=Path.of("test1","TextCopy.txt");
    private static String text = "Hello Lera!\n";
    private static String text2="Wow";
    public static void main(String[] args) {
        Date startTime=new Date();
        int i=text.length()-1;// в какое место в файле надо вставить или заменить текст
        if(i<text.length()-text2.length()){
        }else {
            i=0;
        }
        write(false);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        write(true);
        writeInTheMiddle(i);
        replacement(i);
        replacementInTheMiddleFile(30);
        Date endTime=new Date();
        long totalTime=endTime.getTime()-startTime.getTime();
        System.out.println("Время: "+totalTime+" мс");
    }

    private static void write(boolean append) {
        try(FileOutputStream fos=new FileOutputStream(path.toFile(),append))
        {
            byte[] buffer = text.getBytes();
            for (int i = 0; i < text.length(); i++) {
                fos.write(buffer[i]);
            }
            System.out.println("The file has been written");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void writeInTheMiddle(int i){
        try (FileOutputStream fos=new FileOutputStream(path.toFile(),true)){
            fos.write(text.getBytes(),0,i);
            fos.write(text2.getBytes());
            fos.write(text.getBytes(),i,text.length()-i);
            fos.write("\n".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void replacement(int i){
        try (FileOutputStream fos=new FileOutputStream(path.toFile(),true)){
            fos.write(text.getBytes(),0,i);
            fos.write(text2.getBytes());
            fos.write(text.getBytes(),i+text2.length(),text.length()-i-text2.length());
            fos.write("\n".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void replacementInTheMiddleFile(int i){
        try (FileInputStream fis=new FileInputStream(path.toFile());FileOutputStream fos=new FileOutputStream(pathCopy.toFile())){
            byte[]bytes=new byte[text2.length()];
            int j;
            int byte1=1;
            while ((j=fis.read(bytes))!=-1&&byte1<=i){
                fos.write(bytes,0,j);
                byte1++;
            }
            fos.write(text2.getBytes());
            while ((j=fis.read(bytes))!=-1){
                if(byte1>=i) {
//                    for(int k=0; k<j;k++){
//                        System.out.print((char)bytes[k]);
//                    }
                    fos.write(bytes, 0, j);
                }
                byte1++;
            }
            System.out.println("!!!");
        }catch (IOException e){
            e.printStackTrace();
        }
        try (FileInputStream fis=new FileInputStream(pathCopy.toFile());FileOutputStream fos=new FileOutputStream(path.toFile())){
            byte[]bytes=new byte[1024];
            int j;
            while ((j=fis.read(bytes))!=-1){
                fos.write(bytes,0,j);
            }
            System.out.println("!!!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
