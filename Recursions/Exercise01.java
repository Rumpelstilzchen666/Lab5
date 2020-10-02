package Recursions;

import java.util.Scanner;

public class Exercise01 {
    private static StringBuilder TriangularSequence(long t, long n) {
        StringBuilder str = new StringBuilder();
        for(long i = 0; i < t; i++, n--) {
            if(n == 0)
                return str;
            str.append(t).append(", ");
        }
        return str.append(TriangularSequence(t + 1, n));
    }

    public static String TriangularSequence(long n){
        if(n <= 0)
            return "";
        StringBuilder result = TriangularSequence(1, n);
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long n = console.nextLong();
        while(n != 0) {
            System.out.println(TriangularSequence(n));
            n = console.nextLong();
        }
    }
}