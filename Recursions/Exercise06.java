package Recursions;

import java.util.Scanner;
import java.lang.Math;

public class Exercise06 {
    private static boolean isDivisor(long dividend, long divider) {
        if(divider > 1) {
            if(dividend % divider == 0) {
                //System.out.println(dividend + " % " + divider + " = " + dividend % divider);
                //System.out.println(dividend + " / " + divider + " = " + dividend / divider);
                return true;
            }
            else
                return isDivisor(dividend, divider - 1);
        }
        else
            return false;
    }

    public static boolean isPrime(long x) {
        return (!isDivisor(x, (int) Math.floor(Math.sqrt(x))));
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n > 1) {
            System.out.println(isPrime(n) ? "YES" : "NO");
            n = console.nextLong();
        }
    }
}