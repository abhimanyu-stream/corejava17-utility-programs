package com.java17.utilityprograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ReadAllFilesAndStoreTextInAFile {

    public static void main(String[] args) {
        // Define the source directory to read the filenames from
        Path sourceDirectory = Paths.get("D://Additional-D//song english");  // Change to the directory you want to scan
        Path outputFile = Paths.get("D://Additional-D//song english//output.txt");  // Path to the output text file

        try {
            // Create the output file if it doesn't exist
            if (!Files.exists(outputFile)) {
                Files.createFile(outputFile);
            }

            // Open the output file for writing (overwrite mode)
            try (BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardOpenOption.TRUNCATE_EXISTING)) {
                // Walk through all files in the source directory and subdirectories
                Files.walkFileTree(sourceDirectory, new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        // Only write the filename, not the full path
                        String fileName = file.getFileName().toString();
                        writer.write(fileName);
                        writer.newLine();  // Write a new line after each filename
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                        // Handle file read errors if any (optional)
                        System.err.println("Error accessing file: " + file.toString());
                        return FileVisitResult.CONTINUE;
                    }
                });
            }

            System.out.println("File names have been successfully written to the output file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
