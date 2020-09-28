package Recursions;

import java.util.Scanner;

public class Exercise09 {
    public static long factorial(long n) {
        return (n > 1 ? n * factorial(n - 1) : 1);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n0 = console.nextInt(), n1 = console.nextInt();
        while(n0 != 0 || n1 != 0) {
            if(n0 > n1 + 1)
                System.out.println(0);
            else
                System.out.println(factorial(n1 + 1) /
                        (factorial(n0) * factorial(n1 + 1 - n0)));
            n0 = console.nextInt(); n1 = console.nextInt();
        }
    }
}
