package com.brainacad.hw.FileWork;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class DirView implements IDirView {
    private File path;
    private File[] files;

    public DirView(String pathname) throws IOException {
        path = new File(pathname);
        if (!path.exists()) {
            throw new IOException("Cannot access " + pathname + ": No such file or directory");
        }
        if (path.isFile()) {
            files = new File[]{path};
        } else {
            files = path.listFiles();
            Arrays.sort(files, new DirView.FilesComparator());
        }
    }

    @Override
    public void print() {
        for (File f : files) {
            System.out.println(f.getName() + ((f.isDirectory()) ? File.separator : ""));
        }
    }

    public File[] getFilesAndDir() {
        return files;
    }

    private class FilesComparator implements Comparator<File> {
        public int compare(File f1, File f2) {
            if (f1.isDirectory() && f2.isFile()) {
                return -1;
            }
            if (f1.isFile() && f2.isDirectory()) {
                return 1;
            }
            return 0;
        }
    }
}
