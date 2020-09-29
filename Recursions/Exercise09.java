package Recursions;

import java.util.Scanner;

public interface Exercise09 {
    private static long factorial(long n) {
        return (n > 1 ? n * factorial(n - 1) : 1);
    }

    static long nNumbersWithN00(long n0, long n1){
        return factorial(n1 + 1) /
                (factorial(n0) * factorial(n1 + 1 - n0));
    }

    static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n0 = console.nextInt(), n1 = console.nextInt();
        while(n0 != 0 || n1 != 0) {
            System.out.println(nNumbersWithN00(n0, n1));
            n0 = console.nextInt(); n1 = console.nextInt();
        }
    }
}
