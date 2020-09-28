package Recursions;

import java.util.Scanner;
import java.lang.Math;

public class Exercise06 {
    private static boolean isDivisor(int dividend, int divider) {
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

    public static boolean isPrime(int x) {
        return (!isDivisor(x, (int) Math.floor(Math.sqrt(x))));
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        while(n > 1) {
            System.out.println(isPrime(n) ? "YES" : "NO");
            n = console.nextInt();
        }
    }
}