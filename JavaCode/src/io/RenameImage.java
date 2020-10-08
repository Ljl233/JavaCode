package io;

import java.io.File;

public class RenameImage {
    public static void main(String[] args) {
        File dir = new File("//home//ljl233//Downloads");
        if (!dir.isDirectory()) return;
        int i = 0;
        for (String s : dir.list()) {
            if (isImageFile(s)) {
                String oldName = dir + "//" + s;
                String newName = dir + "//" + "wallpaper_" + i++ + ".jpg";
                if (renameImage(new File(oldName), newName)) {
                    System.out.println();
                }
            }
        }
    }

    static boolean renameImage(File image, String name) {
        return image.renameTo(new File(name));
    }

    static boolean isImageFile(String name) {
        return name.contains(".jpg");
    }
}
