package com.education.transaction.processing;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileFilter {

    public File[] filter(String dirPath, boolean isAbsolutePath) {
        File dir = new File(isAbsolutePath ? dirPath : Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(dirPath)).getFile());
        return dir.listFiles((dir1, filename) -> filename.toLowerCase().endsWith(".txt"));
    }
}