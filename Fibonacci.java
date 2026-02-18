import java.util.Scanner;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static int callCount = 0;
    // Map for memoization
    private static Map<Integer, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the position (n): ");
        
        try {
            if (input.hasNextInt()) {
                int n = input.nextInt();
                
                // Call the recursive function and print results
                BigInteger result = fibonacci(n);
                
                System.out.println("Fibonacci position " + n + " is: " + result);
                System.out.println("Total recursive calls made: " + callCount);
            } else {
                System.out.println("Error: Please enter a valid integer.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    /**
     * Calculates the nth Fibonacci number using recursion and memoization.
     * Logic: F(n) = F(n-1) + F(n-2)
     */
    public static BigInteger fibonacci(int n) {
        callCount++;
        
        //Error Handling
        if (n < 0) throw new IllegalArgumentException("Negative input not allowed");

        // Base Cases
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        // Memoization Check
        if (memo.containsKey(n)) return memo.get(n);

        //Recursive Step: Calculate F(n-1) + F(n-2)
        BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
        
        // Store the result in the map before returning
        memo.put(n, result); 
        
        return result;
    }
}
