package Recursions;

import java.util.Scanner;

public interface Exercise05 {
    static long sumOfDigits(long n) {
        return n % 10 + (n > 100 ? sumOfDigits(n / 10) : n / 10);
    }

    static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n;
        do {
            n = console.nextLong();
            System.out.println(sumOfDigits(n));
        } while(n != 0);
    }
}
