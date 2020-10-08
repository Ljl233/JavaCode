package io;

import java.io.File;
import java.io.IOException;

public class RMFile {
    public static void main(String[] args) {
        File file = new File("hahaha");
        System.out.println(file.isAbsolute());

        System.out.println("absolutePath=" + file.getAbsolutePath());

        String path = file.getAbsolutePath();
        try {
            path = file.getCanonicalPath();
            System.out.println("file.getCanonicalPath()=" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        file = file.getAbsoluteFile();

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("create file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        file.renameTo(new File("file.md"));
//        deleteFile(file);
//        System.out.println(file.compareTo(new File("ahaha")));
//        System.out.println(file.getName());

        File parentFile = file.getParentFile();
        System.out.println(parentFile);
        for (int i = 0; i < parentFile.list().length; i++) {
            System.out.println(parentFile.list()[i]);
        }
    }

    static boolean deleteFile(File file) {
        return file.delete();
    }
}
