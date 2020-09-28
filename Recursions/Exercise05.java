package Recursions;

import java.util.Scanner;

public class Exercise05 {
    private static long sumOfDigits(long n) {
        return n % 10 + (n > 100 ? sumOfDigits(n / 10) : n / 10);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n;
        do {
            n = console.nextLong();
            System.out.println(sumOfDigits(n));
        } while(n != 0);
    }
}
