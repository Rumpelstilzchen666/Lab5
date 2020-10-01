package Recursions;

import java.util.Scanner;

public class Exercise07 {
    public static String getDivisors(long dividend, long divider) {
        if(divider < dividend) {
            if(dividend % divider == 0)
                return divider + ", " +
                        getDivisors(dividend / divider, divider);
            else
                return getDivisors(dividend, divider + 1);
        }
        return divider + ", ";
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n > 1) {
            System.out.println(getDivisors(n, 2));
            n = console.nextLong();
        }
    }
}