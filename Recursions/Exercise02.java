package Recursions;

import java.util.Scanner;

public class Exercise02 {
    private static void fromAtoB(int a, int b) {
        System.out.print(a + ", ");
        if(a != b)
            fromAtoB(a + 1, b);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        while(n > 0) {
            fromAtoB(1, n);
            System.out.println("\b\b");
            n = console.nextInt();
        }
    }
}