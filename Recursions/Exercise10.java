package Recursions;

import java.util.Scanner;
import java.lang.Math;

public class Exercise10 {
    public static long easyInvert(long n) {
        return Long.parseLong(
                new StringBuilder(String.valueOf(n)).reverse().toString());
    }

    public static long invert(long n) {
        if(Math.abs(n) >= 10) {
            long temp = 1;
            while(temp <= Math.abs(n))
                temp *= 10;
            return invert(n / 10) + (n % 10) * temp / 10;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n != 0) {
            System.out.println(invert(n));
            n = console.nextLong();
        }
    }
}