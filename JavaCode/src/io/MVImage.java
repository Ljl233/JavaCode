package io;

import java.io.*;

public class MVImage {
    public static void main(String[] args) {
        File dirFrom = new File("//home//ljl233//Downloads");
        File dirTo = new File("//home//ljl233//Pictures");

        if (!dirFrom.isDirectory()) return;

        String[] images = dirFrom.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains(".jpg");
            }
        });

        for (String image : images) {
            System.out.println(image);
            move(dirFrom, dirTo, "/"+image);
            System.out.println("move " + image);
        }
    }

    static void move(File from, File to, String fileName) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream =
                    new FileInputStream(from.getAbsoluteFile() + fileName);
            outputStream = new FileOutputStream(to.getAbsoluteFile() + fileName);

            byte[] buf = new byte[inputStream.available()];

            inputStream.read(buf);
            outputStream.write(buf);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
