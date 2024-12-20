package com.java17.utilityprograms;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ReadAllFilesAndDirectoriesRecursively {
    public static void main(String[] args) {
        // Define the starting directory to begin the search
        Path startDir = Paths.get("D://Additional-D//song english"); // Change this to your desired directory



        // Start traversing the directory tree recursively
        try {
            Files.walkFileTree(startDir, new SimpleFileVisitor<Path>() {

                // This method is called for every file encountered
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("File: " + file.toString());  // Print file path
                    return FileVisitResult.CONTINUE;
                }

                // This method is called for every directory encountered
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("Directory: " + dir.toString());  // Print directory path
                    return FileVisitResult.CONTINUE;
                }

                // This method is called when a file or directory fails to be accessed
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Error accessing file or directory: " + file.toString());
                    return FileVisitResult.CONTINUE;  // Continue processing other files
                }
            });
        } catch (IOException e) {
            e.printStackTrace();  // Print any IO exceptions
        }


        Path startDirectory = Paths.get("D://Additional-D//song english");  // Change to your directory
        try {
            readDirectoryRecursively(startDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readDirectoryRecursively(Path dir) throws IOException {
        // Print the current directory
        System.out.println("Directory: " + dir.toString());

        // List all entries in the directory
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    // If it's a directory, recurse into it
                    readDirectoryRecursively(entry);
                } else {
                    // If it's a file, print the filename
                    System.out.println("File: " + entry.toString());
                }
            }
        }
    }
}

