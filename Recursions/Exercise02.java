package Recursions;

import java.util.Scanner;

public interface Exercise02 {
    static String fromAtoB(int a, int b) {
        if(a != b)
            return a + ", " + fromAtoB(a + 1, b);
        return String.valueOf(a);
    }

    static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        while(n > 0) {
            System.out.println(fromAtoB(1, n));
            n = console.nextInt();
        }
    }
}