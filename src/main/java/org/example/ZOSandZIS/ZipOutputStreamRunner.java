package org.example.ZOSandZIS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamRunner {
    private static Path path = Path.of("test1", "output.zip");
    private static Path path2 = Path.of("test1", "NotesZip.txt");
    public static void main(String[] args) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path.toFile()));
             FileInputStream fis = new FileInputStream(path2.toFile())) {
            ZipEntry entry1 = new ZipEntry("test1/NotesZip.txt");
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
