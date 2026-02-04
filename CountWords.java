import java.net.URI;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        String targetUrl = "https://liveexample.pearsoncmg.com/data/Lincoln.txt";
        int wordCount = 0;

        // Try-with-resources automatically closes the stream for us
        try (Scanner input = new Scanner(URI.create(targetUrl).toURL().openStream())) {
            
            while (input.hasNext()) {
                input.next(); 
                wordCount++;
            }

            System.out.printf("Finished. Found %d words in the document.%n", wordCount);

        } catch (Exception e) {
            System.err.println("Could not read the file: " + e.getMessage());
        }
    }
}





    

