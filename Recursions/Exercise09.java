package Recursions;

import java.util.Scanner;

public class Exercise09 {
    private static long factorial(long n) {
        return (n > 1 ? n * factorial(n - 1) : 1);
    }

    public static long nNumbersWithN00(long n0, long n1) {
        if(n0 < 0 || n1 < 0 || (n0 == 0 && n1 == 0 ))
            return 0;
        return factorial(n1 + 1) / factorial(n0) / factorial(n1 + 1 - n0);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n0 = console.nextLong(), n1 = console.nextLong();
        while(n0 != 0 || n1 != 0) {
            System.out.println(nNumbersWithN00(n0, n1));
            n0 = console.nextLong(); n1 = console.nextLong();
        }
    }
}