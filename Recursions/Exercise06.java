package Recursions;

import java.util.Scanner;
import java.lang.Math;

public class Exercise06 {
    private static boolean isDivisor(long dividend, long divider) {
        if(divider > 1) {
            if(dividend % divider == 0)
                return true;
            else
                return isDivisor(dividend, divider - 1);
        }
        else
            return false;
    }

    public static String isPrime(long x) {
        if(x < 2)
            return "NO";
        return (!isDivisor(x, (int) Math.floor(Math.sqrt(x))) ? "YES" : "NO");
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n > 1) {
            System.out.println(isPrime(n));
            n = console.nextLong();
        }
    }
}