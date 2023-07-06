package org.example.File;

import java.io.File;

public class DirDelete {
    public static void main(String[] args) {
        File dir = new File("D://work//projects//StreamApi//JavaBookExamples//NewDir");
        boolean created = dir.mkdir();
        if (created) {
            System.out.println("Folder has been created");
        }
        File newDir = new File("D://work//projects//StreamApi//JavaBookExamples//NewDirRenamed");
        dir.renameTo(newDir);
        boolean deleted = newDir.delete();
        if (deleted) {
            System.out.println("Folder has been deleted");
        }
    }
}
