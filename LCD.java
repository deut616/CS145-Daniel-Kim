import java.util.Scanner;

public class LCD {

    // Recursive GCD
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    // LCM using GCD
    public static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    // Safe integer input method
    public static int getValidInt(Scanner sc, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = sc.nextInt();
                if (value <= 0) {
                    System.out.println("Value must be positive.");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine(); // clear bad input
            }
        }
    }

    // Recursive LCD computation for remaining denominators
    public static int computeLCD(Scanner sc, int count, int currentLCD) {
        if (count == 0) return currentLCD; // base case

        int next = getValidInt(sc, "Enter next denominator: ");
        int newLCD = LCM(currentLCD, next);

        return computeLCD(sc, count - 1, newLCD); // recursive step
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Ask user how many denominators there will be
        int numDenominators = getValidInt(sc, "How many denominators? ");

        // Step 2: Ask for the first denominator
        int first = getValidInt(sc, "Enter denominator 1: ");

        // Step 3: Compute LCD recursively for the remaining denominators
        int lcd = computeLCD(sc, numDenominators - 1, first);

        // Step 4: Output the result
        System.out.println("The LCD is: " + lcd);

        sc.close();
    }
}