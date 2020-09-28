package Recursions;

import java.util.Scanner;

public class Exercise01 {
    private static void TriangularSequence(int t, int n) {
        for(int i = 0; i < t; i++, n--) {
            if(n == 0)
                return;
            System.out.print(t + ", ");
        }
        TriangularSequence(t + 1, n);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        while(n > 0) {
            TriangularSequence(1, n);
            System.out.println("\b\b");
            n = console.nextInt();
        }
    }
}