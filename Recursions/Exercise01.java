package Recursions;

import java.util.Scanner;

public class Exercise01 {
    public static String TriangularSequence(long t, long n) {
        StringBuilder str = new StringBuilder();
        for(long i = 0; i < t; i++, n--) {
            if(n == 0)
                return str.toString();
            str.append(t).append(", ");
        }
        return str + TriangularSequence(t + 1, n);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n != 0) {
            System.out.println(TriangularSequence(1, n) + "\b\b");
            n = console.nextLong();
        }
    }
}