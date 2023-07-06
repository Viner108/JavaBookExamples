package org.example.ZOSandZIS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZIpInputStreamRunner {
    private static Path path = Path.of("test1", "output.zip");
    public static void main(String[] args) {

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(path.toFile())))
        {
            ZipEntry entry;
            String name;
            while((entry=zin.getNextEntry())!=null){
                name = entry.getName();
                System.out.printf("File name: %s \n", name);
                Path path2 = Path.of("test1", "newNotesZip.txt");
                FileOutputStream fout = new FileOutputStream(path2.toFile());
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
