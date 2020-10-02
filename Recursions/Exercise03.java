package Recursions;

import java.util.Scanner;

public class Exercise03 {
    public static StringBuilder fromAtoB(long a, long b) {
        if(a != b)
            return fromAtoB(a, (a < b ? b - 1 : b + 1)).append(", ").append(b);
        return new StringBuilder(String.valueOf(b));
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