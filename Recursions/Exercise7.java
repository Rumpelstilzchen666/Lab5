package Recursions;

import java.util.Scanner;

public class Exercise7 {
    private static void printDivisors(int dividend, int divider) {
        if(divider <= dividend) {
            if(dividend % divider == 0) {
                System.out.print(divider + ", ");
                printDivisors(dividend / divider, divider);
            }
            else {
                printDivisors(dividend, divider + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        while(n > 1) {
            printDivisors(n, 2);
            System.out.println("\b\b");
            n = console.nextInt();
        }
    }
}
