package Recursions;

import java.util.Scanner;

public class Exercise02 {
    public static String from1toB(long b){
        return Exercise03.fromAtoB(1, b).toString();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long b = console.nextLong();
        while(b > 0) {
            System.out.println(from1toB(b));
            b = console.nextLong();
        }
    }
}