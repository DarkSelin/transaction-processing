package com.education.transaction.processing;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Processor {

    private String inputDirPath;
    private String outputDirPath;
    private FileFilter fileFilter;

    public Processor(String inputDirPath, String outputDirPath) {
        this.inputDirPath = inputDirPath;
        this.outputDirPath = outputDirPath;
        fileFilter = new FileFilter();
    }

    public static void main(String[] args) {
        PropertiesHolder propertiesHolder = new PropertiesHolder("app.properties");
        Processor processor = new Processor(propertiesHolder.getProperty("inputDir"), propertiesHolder.getProperty("outputDir"));
        processor.run();
    }

    public void run() {
        List<File> files = Arrays.asList(fileFilter.filter(inputDirPath, false));
        // TODO: write parse file code in separate method
    }

}
