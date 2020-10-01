package Recursions;

import java.util.Scanner;

public class Exercise02 {
    public static String fromAtoB(long a, long b) {
        if(a != b)
            return a + ", " + fromAtoB(a + 1, b);
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n > 0) {
            System.out.println(fromAtoB(1, n));
            n = console.nextLong();
        }
    }
}