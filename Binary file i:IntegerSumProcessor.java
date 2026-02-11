import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger; //logger import instead of printstacktrace method.


 
public class IntegerSumProcessor {

    private static final Logger LOGGER = Logger.getLogger(IntegerSumProcessor.class.getName());

    public static void main(String[] args) {
        // Use a path variable or config—never hardcode inside the logic
        Path filePath = Paths.get("Exercise17_3.dat");
        
        if (!Files.exists(filePath)) {
            LOGGER.log(Level.SEVERE, "Target file {0} does not exist.", filePath);
            return;
        }

        long totalSum = calculateSum(filePath);
        System.out.printf("Processing complete. Total sum: %,d%n", totalSum);
    }

    /**
     * Logic is separated into its own method for testability.
     */
    public static long calculateSum(Path path) {
        long sum = 0; // Use long to prevent integer overflow for large files

        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(path.toFile())))) {
            // Check available bytes instead of waiting for an exception to crash the loop
            while (input.available() >= 4) { 
                sum += input.readInt();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading binary file: " + path, e);
        }

        return sum;
    }
}


