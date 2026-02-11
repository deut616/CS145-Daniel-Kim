package integersumprocessor;

import java.io.*;

public class IntegerSumProcessor {
    public static void main(String[] args) {
        // Using File instead of Path (more common in intro courses)
        File file = new File("Exercise17_3.dat");

        // Basic check with a simple print statement
        if (!file.exists()) {
            System.err.println("File not found: " + file.getName());
            return;
        }

        try {
            long total = calculateSum(file);
            System.out.println("Total sum: " + total);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public static long calculateSum(File file) throws IOException {
        long sum = 0;

        // Using a simpler stream setup
        try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
            // Using available() is fine, but looping until EOF is very "human student"
            while (input.available() > 0) {
                sum += input.readInt();
            }
        }
        
        return sum;
    }
}

