/*
 * Name: Daniel Kim
 * Lab: Exercise 12.26 (Part 2 - Create Directory)
 * Date: 2026-02-03
 */


import java.io.File;
import java.util.Scanner;

public class DirectoryException {
    public static void main(String[] args) {
        // Start timer
        long startTime = System.nanoTime();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a directory name: ");
            String dirName = scanner.nextLine();

            File directory = new File(dirName);

            if (directory.exists()) {
                System.out.println("Status: Directory already exists.");
            } else if (directory.mkdirs()) {
                System.out.println("Status: Directory created successfully.");
            } else {
                System.out.println("Status: Failed to create directory.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred during execution: " + e.getMessage());
        } finally {
            // CTrack Execution times
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000; // Unit conversion to milliseconds
            System.out.println("-----------------------------------");
            System.out.println("Execution Time: " + duration + " ms");
        }
    }
}

