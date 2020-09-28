package Recursions;

import java.util.Scanner;

public class Exercise03 {
    private static void fromAtoB(int a, int b) {
        System.out.print(a + ", ");
        if(a != b)
            fromAtoB((a < b ? a + 1 : a - 1), b);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a, b;
        do {
            a = console.nextInt(); b = console.nextInt();
            fromAtoB(a, b);
            System.out.println("\b\b");
        } while(a != 0 || b != 0);
    }
}