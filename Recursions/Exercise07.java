package Recursions;

import java.util.Scanner;

public interface Exercise07 {
    static String printDivisors(int dividend, int divider) {
        if(divider < dividend) {
            if(dividend % divider == 0)
                return divider + ", " +
                        printDivisors(dividend / divider, divider);
            else
                return printDivisors(dividend, divider + 1);
        }
        return String.valueOf(divider);
    }

    static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        while(n > 1) {
            System.out.println(printDivisors(n, 2));
            n = console.nextInt();
        }
    }
}