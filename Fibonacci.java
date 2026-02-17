import java.util.Scanner;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static int callCount = 0;
    // Using a Map for memoization to prevent the program from hanging
    private static Map<Integer, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the position: ");
        
        if (input.hasNextInt()) {
            int n = input.nextInt();
            System.out.println("Result: " + fibonacci(n));
            System.out.println("Total calls: " + callCount);
        }
        input.close();
    }

    public static BigInteger fibonacci(int n) {
        callCount++;
        if (n <= 1) return BigInteger.valueOf(n);
        
        // Check if we've already calculated this number
        if (memo.containsKey(n)) return memo.get(n);

        BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
        memo.put(n, result); // Store it for later
        return result;
    }
}