package integersumprocessor;

import java.io.*;

public class Exercise17_03 {

    public static void main(String[] args) {
        File file = new File("Exercise17_3.dat");
        generateBinaryFile(file);

        //  Read the binary file, print integers, and sum them
        if (!file.exists()) {
            System.err.println("File not found: " + file.getName());
            return;
        }

        try {
            long totalSum = readAndSumIntegers(file);
            System.out.println("Processing complete. Total sum: " + totalSum);
        } catch (IOException e) {
            System.err.println("Error reading the binary file.");
            e.printStackTrace();
        }
    }

    // binary file generation w/ 100 random integers
    private static void generateBinaryFile(File file) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < 100; i++) {
                int randomNumber = (int) (Math.random() * 100000);
                output.writeInt(randomNumber);
            }
        } catch (IOException e) {
            System.err.println("Error creating the binary file.");
            e.printStackTrace();
        }
    }

    private static long readAndSumIntegers(File file) throws IOException {
        long sum = 0;

        try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
            while (input.available() > 0) {
                int number = input.readInt();
                System.out.println(number); // print each integer
                sum += number;
            }
        }

        return sum;
    }
}



