import java.math.BigInteger;
import java.util.Scanner;

public class RecursionFactorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer (>= 0): ");
        try {
            int number = input.nextInt();

            if (number < 0) {
                System.out.println("Error: Negative numbers not allowed.");
            } else {
                System.out.println("Factorial of " + number + " is: " + factorial(number));
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            input.close();
        }
    }

    public static BigInteger factorial(int n) {
        // Base case
        if (n == 0) return BigInteger.ONE;

        // Recursive multiplication
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}
