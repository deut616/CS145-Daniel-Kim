import java.util.Scanner;

public class PascalsTriangle {

    // Helper to get the actual math value
    public static int getValue(int r, int c) {
        if (c == 0 || c == r) return 1;
        return getValue(r - 1, c - 1) + getValue(r - 1, c);
    }

    //printing the spaces
    public static void printSpaces(int count) {
        if (count <= 0) return;
        System.out.print(" ");
        printSpaces(count - 1); // call itself until spaces are done
    }

    // Recursive method to print the numbers in a single row
    public static void printRow(int r, int c) {
        if (c > r) return;
        System.out.print(getValue(r, c) + " ");
        printRow(r, c + 1); // call itself for the next number
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int totalRows = input.nextInt();
        // Still using a main loop to trigger the recursive calls for each line
        for (int i = 0; i < totalRows; i++) {
            printSpaces(totalRows - i); 
            printRow(i, 0);
            System.out.println();
        }
        input.close();
    }
}