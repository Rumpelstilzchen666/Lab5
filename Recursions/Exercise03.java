package Recursions;

import java.util.Scanner;

public interface Exercise03 {
    static String fromAtoB(int a, int b) {
        if(a != b)
            return a + ", " + fromAtoB((a < b ? a + 1 : a - 1), b);
        return String.valueOf(a);
    }

    static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a, b;
        do {
            a = console.nextInt(); b = console.nextInt();
            System.out.println(fromAtoB(a, b));
        } while(a != 0 || b != 0);
    }
}