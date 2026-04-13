package com.example;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import com.google.common.collect.ImmutableList;

public class App {

    public static void main(String[] args) {

        // Immutable list using Guava
        ImmutableList<String> fruits = ImmutableList.of("Apple", "Banana", "Cherry");
        System.out.println("Fruits List: " + fruits);

        // Define files
        File sourceFile = new File("source.txt");
        File destFile = new File("destination.txt");

        try {
            // 🔥 Create source file if it doesn't exist
            if (!sourceFile.exists()) {
                System.out.println("source.txt not found. Creating file...");
                FileUtils.writeStringToFile(sourceFile, "Sample content for testing", "UTF-8");
            }

            // Copy file
            FileUtils.copyFile(sourceFile, destFile);

            System.out.println("✅ File copied successfully!");
            System.out.println("Source: " + sourceFile.getAbsolutePath());
            System.out.println("Destination: " + destFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("❌ Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
