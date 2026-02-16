
import java.math.BigInteger;
import java.util.Scanner;

public class RecursionFactorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

   
        System.out.print("Enter an integer of any size: ");
        int n = input.nextInt();

        // Call the recursive method
        System.out.println(factorial(n));
        
        input.close();
    }

    
    public static BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE; // Base case
        } else {
            
            return BigInteger.valueOf(n).multiply(factorial(n - 1));
        }
    }
}
