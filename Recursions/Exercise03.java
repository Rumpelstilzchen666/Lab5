package Recursions;

import java.util.Scanner;

public class Exercise03 {
    public static String fromAtoB(long a, long b) {
        if(a != b)
            return a + ", " + fromAtoB((a < b ? a + 1 : a - 1), b);
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long a, b;
        do {
            a = console.nextLong(); b = console.nextLong();
            System.out.println(fromAtoB(a, b));
        } while(a != 0 || b != 0);
    }
}