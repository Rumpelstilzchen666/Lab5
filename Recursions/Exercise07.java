package Recursions;

import java.util.Scanner;

public class Exercise07 {
    private static StringBuilder getDivisors(long dividend, long divider) {
        if(divider < dividend) {
            if(dividend % divider == 0)
                return new StringBuilder(String.valueOf(divider)).append(", ")
                        .append(getDivisors(dividend / divider, divider));
            else
                return getDivisors(dividend, divider + 1);
        }
        return new StringBuilder(String.valueOf(divider));
    }

    public static String getDivisors(long n) {
        if(n < 2)
            return "";
        return getDivisors(n, 2).toString();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n > 1) {
            System.out.println(getDivisors(n));
            n = console.nextLong();
        }
    }
}